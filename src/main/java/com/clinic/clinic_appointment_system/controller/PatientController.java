package com.clinic.clinic_appointment_system.controller;

import com.clinic.clinic_appointment_system.dto.PatientDto;
import com.clinic.clinic_appointment_system.model.Patient;
import com.clinic.clinic_appointment_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody PatientDto patientDto) {
        Patient patient = patientService.addPatient(
                patientDto.getName(), patientDto.getAge(), patientDto.getGender());
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }
}
