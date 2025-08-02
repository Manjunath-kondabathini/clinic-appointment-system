package com.clinic.clinic_appointment_system.repository;

import com.clinic.clinic_appointment_system.model.Appointment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class AppointmentRepository {

    private final Map<Long, Appointment> appointments = new ConcurrentHashMap<>();

    public Appointment save(Appointment appointment) {
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }

    public List<Appointment> findByDoctorId(Long doctorId) {
        return appointments.values().stream()
                .filter(app -> app.getDoctorId().equals(doctorId))
                .collect(Collectors.toList());
    }

    public boolean isSlotBooked(Long doctorId, LocalDateTime slot) {
        return appointments.values().stream()
                .anyMatch(a -> a.getDoctorId().equals(doctorId) && a.getSlot().equals(slot));
    }
}
