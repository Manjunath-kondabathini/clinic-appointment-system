package com.clinic.clinic_appointment_system.model;

import java.util.concurrent.atomic.AtomicLong;

public class Patient {

    private static final AtomicLong idCounter = new AtomicLong();

    private Long id;
    private String name;
    private int age;
    private String gender;

    public Patient() {}

    public Patient(String name, int age, String gender) {
        this.id = idCounter.incrementAndGet();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
