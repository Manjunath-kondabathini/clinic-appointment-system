package com.clinic.clinic_appointment_system.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Doctor {

    private static final AtomicLong idCounter = new AtomicLong();

    private Long id;
    private String name;
    private String specialization;
    private List<LocalDateTime> availableSlots;

    public Doctor() {}

    public Doctor(String name, String specialization, List<LocalDateTime> availableSlots) {
        this.id = idCounter.incrementAndGet();
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = availableSlots;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public List<LocalDateTime> getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(List<LocalDateTime> availableSlots) { this.availableSlots = availableSlots; }
}
