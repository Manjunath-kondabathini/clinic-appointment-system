package com.clinic.clinic_appointment_system.service;

import com.clinic.clinic_appointment_system.exception.NotFoundException;
import com.clinic.clinic_appointment_system.exception.ValidationException;
import com.clinic.clinic_appointment_system.model.Appointment;
import com.clinic.clinic_appointment_system.model.Doctor;
import com.clinic.clinic_appointment_system.model.Patient;
import com.clinic.clinic_appointment_system.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    private final Object bookingLock = new Object();

    public Appointment bookAppointment(Long doctorId, Long patientId, LocalDateTime slot) {
        Doctor doctor = doctorService.findById(doctorId);
        Patient patient = patientService.findById(patientId);

        if (!doctor.getAvailableSlots().contains(slot)) {
            throw new ValidationException("Requested slot is not in doctor's available slots");
        }

        synchronized (bookingLock) {
            if (appointmentRepository.isSlotBooked(doctorId, slot)) {
                throw new ValidationException("Slot is already booked");
            }

            Appointment appointment = new Appointment(doctorId, patientId, slot);
            appointmentRepository.save(appointment);

            doctor.getAvailableSlots().remove(slot);
            doctorService.updateDoctor(doctor);

            return appointment;
        }
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findByDoctorId(Long doctorId) {
        doctorService.findById(doctorId); // validate doctor exists
        return appointmentRepository.findByDoctorId(doctorId);
    }
}
