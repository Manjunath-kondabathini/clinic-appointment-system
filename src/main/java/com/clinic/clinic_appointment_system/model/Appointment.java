package com.clinic.clinic_appointment_system.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {

    private static final AtomicLong idCounter = new AtomicLong();

    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDateTime slot;

    public Appointment() {}

    public Appointment(Long doctorId, Long patientId, LocalDateTime slot) {
        this.id = idCounter.incrementAndGet();
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.slot = slot;
    }

    public Long getId() { return id; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public LocalDateTime getSlot() { return slot; }
    public void setSlot(LocalDateTime slot) { this.slot = slot; }
}
