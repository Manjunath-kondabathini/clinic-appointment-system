CLINIC APPOINTMENT MANAGEMENT SYSTEM

This Spring Boot project implements a Clinic Appointment Management System that allows management of doctors, patients, and appointment bookings for a small clinic setup. Data is stored in-memory, and the application uses modern Java and Spring Boot practices.

WHAT I HAVE DONE

This project implements a basic appointment management system with the following key features and design decisions:

- Doctor Management  
  - Add new doctors with details such as name, specialization, and a list of available appointment slots.  
  - Retrieve the list of all doctors or get the details of a specific doctor by ID.  
  - Filter available slots by date.

- Patient Management  
  - Register patients with basic information: name, age, and gender.  
  - Fetch a list of all registered patients.

- Appointment Booking  
  - Book appointments for patients with doctors at specific available slots.  
  - Ensures thread-safe booking to prevent double booking of the same slot.  
  - Retrieve all appointments or fetch appointments filtered by doctor.

- In-Memory Data Storage  
  - Uses thread-safe collections to store Doctors, Patients, and Appointments in memory without any external database dependency.  
  - Suitable for demo, testing, or lightweight use.

- Modern Java and Spring Boot Features  
  - Java 8 features including Streams, Optional, Lambdas for cleaner and efficient code.  
  - Clean layered architecture with separate packages for controllers, services, repositories, models, DTOs, and exceptions.  
  - Validation of inputs using Jakarta Bean Validation (@NotNull, @NotEmpty, etc.) and global exception handling.

SETUP INSTRUCTIONS

Prerequisites

- Java 17 or higher installed on your machine  
- Maven build tool installed  
- Optional: An IDE such as Eclipse or IntelliJ IDEA for easier development

Running the Application

1. Clone the repository:
   git clone https://github.com/your-username/clinic-appointment-system.git  
   cd clinic-appointment-system

2. Build and run with Maven:
   mvn spring-boot:run  
   or build the jar and run:  
   mvn clean package  
   java -jar target/clinic-appointment-system-0.0.1-SNAPSHOT.jar

3. The application will start on port 8080 (default) or the port you configured.

4. Use any REST client (Postman, curl, etc.) to interact with the API endpoints.

API USAGE

Doctors

- Add a new doctor  
  POST /doctors  
  Request JSON:  
  {  
    "name": "Dr. Alice Smith",  
    "specialization": "Cardiology",  
    "availableSlots": [  
      "2025-08-10T09:00:00",  
      "2025-08-10T10:00:00"  
    ]  
  }

- Get all doctors  
  GET /doctors

- Get doctor details by ID  
  GET /doctors/{id}

- Get available slots for a doctor (optionally filter by date)  
  GET /doctors/{id}/available-slots?date=2025-08-10

Patients

- Register a new patient  
  POST /patients  
  Request JSON:  
  {  
    "name": "John Doe",  
    "age": 30,  
    "gender": "Male"  
  }

- Get all patients  
  GET /patients

Appointments

- Book an appointment  
  POST /appointments  
  Request JSON:  
  {  
    "doctorId": 1,  
    "patientId": 1,  
    "slot": "2025-08-10T09:00:00"  
  }

- Get all appointments  
  GET /appointments

- Get appointments for a specific doctor  
  GET /appointments/doctor/{doctorId}

SAMPLE OUTPUT

<img width="924" height="407" alt="Screenshot 2025-08-02 115330" src="https://github.com/user-attachments/assets/4c61388f-29a5-4050-8f37-3c0eaaa5a77c" />


AUTHOR

Manjunath Kondabathini

