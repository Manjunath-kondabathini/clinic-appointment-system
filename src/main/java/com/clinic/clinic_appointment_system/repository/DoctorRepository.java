package com.clinic.clinic_appointment_system.repository;

import com.clinic.clinic_appointment_system.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DoctorRepository {

    private final Map<Long, Doctor> doctors = new ConcurrentHashMap<>();

    public Doctor save(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public Optional<Doctor> findById(Long id) {
        return Optional.ofNullable(doctors.get(id));
    }

    public List<Doctor> findAll() {
        return new ArrayList<>(doctors.values());
    }
}
