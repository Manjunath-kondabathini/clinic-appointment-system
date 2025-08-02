package com.clinic.clinic_appointment_system.controller;

import com.clinic.clinic_appointment_system.dto.DoctorDto;
import com.clinic.clinic_appointment_system.model.Doctor;
import com.clinic.clinic_appointment_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        Doctor doctor = doctorService.addDoctor(
                doctorDto.getName(),
                doctorDto.getSpecialization(),
                doctorDto.getAvailableSlots());
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @GetMapping("/{id}/available-slots")
    public List<LocalDateTime> getAvailableSlots(
            @PathVariable Long id,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return doctorService.getAvailableSlotsFiltered(id, date);
    }
}
