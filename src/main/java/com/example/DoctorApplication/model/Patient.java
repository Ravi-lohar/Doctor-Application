package com.example.DoctorApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Size(min = 3,message = "Name should contain at least 3 characters.")
    @Column(name = "Name")
    private String patientName;

    @Size(max = 20,message = "City name should contains max 20 characters")
    @Column(name = "City")
    private String patientCity;

    @Email(message = "Enter a Valid EmailId")
    @Column(name = "Email",unique = true)
    private String patientEmail;

    @Size(min = 10,message = "Phone number should contains at least 10 numbers")
    @Column(name = "Phone Number",unique = true)
    private String patientPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "Symptom")
    private Symptoms patientSymptom;


}
