package com.clinic.clinic_appointment_system.service;

import com.clinic.clinic_appointment_system.exception.NotFoundException;
import com.clinic.clinic_appointment_system.model.Doctor;
import com.clinic.clinic_appointment_system.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(String name, String specialization, List<LocalDateTime> availableSlots) {
        Doctor doctor = new Doctor(name, specialization, availableSlots);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor with id " + id + " not found"));
    }

    public List<LocalDateTime> getAvailableSlotsFiltered(Long doctorId, LocalDate date) {
        Doctor doctor = findById(doctorId);
        if (date != null) {
            return doctor.getAvailableSlots().stream()
                    .filter(slot -> slot.toLocalDate().equals(date))
                    .collect(Collectors.toList());
        }
        return doctor.getAvailableSlots();
    }

    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
