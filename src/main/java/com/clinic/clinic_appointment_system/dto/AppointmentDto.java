package com.clinic.clinic_appointment_system.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentDto {

    @NotNull(message = "Doctor ID must be provided")
    private Long doctorId;

    @NotNull(message = "Patient ID must be provided")
    private Long patientId;

    @NotNull(message = "Slot must be provided")
    private LocalDateTime slot;

    // Getters and Setters

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void setSlot(LocalDateTime slot) {
        this.slot = slot;
    }
}
