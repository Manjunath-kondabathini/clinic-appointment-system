package com.clinic.clinic_appointment_system.repository;

import com.clinic.clinic_appointment_system.model.Patient;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PatientRepository {

    private final Map<Long, Patient> patients = new ConcurrentHashMap<>();

    public Patient save(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Optional<Patient> findById(Long id) {
        return Optional.ofNullable(patients.get(id));
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients.values());
    }
}
