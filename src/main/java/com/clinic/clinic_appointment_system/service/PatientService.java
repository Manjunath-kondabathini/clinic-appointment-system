package com.clinic.clinic_appointment_system.service;

import com.clinic.clinic_appointment_system.exception.NotFoundException;
import com.clinic.clinic_appointment_system.model.Patient;
import com.clinic.clinic_appointment_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(String name, int age, String gender) {
        Patient patient = new Patient(name, age, gender);
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found"));
    }
}
