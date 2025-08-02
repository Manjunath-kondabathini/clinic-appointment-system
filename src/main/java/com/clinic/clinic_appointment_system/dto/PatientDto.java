package com.clinic.clinic_appointment_system.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class PatientDto {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Age must be zero or positive")
    private int age;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
