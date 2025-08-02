package com.clinic.clinic_appointment_system.controller;

import com.clinic.clinic_appointment_system.dto.AppointmentDto;
import com.clinic.clinic_appointment_system.model.Appointment;
import com.clinic.clinic_appointment_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@Valid @RequestBody AppointmentDto dto) {
        Appointment appointment = appointmentService.bookAppointment(
                dto.getDoctorId(),
                dto.getPatientId(),
                dto.getSlot());
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Long doctorId) {
        return appointmentService.findByDoctorId(doctorId);
    }
}
