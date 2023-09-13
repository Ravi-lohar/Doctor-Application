package com.example.DoctorApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long doctorId;

    @Column(name = "Name")
    private String doctorName;

    @Column(name = "Email",unique = true)
    private String doctorEmail;

    @Column(name = "Phone" ,unique = true)
    private String doctorPhone;

    @Column(name = "City")
    @Enumerated(EnumType.STRING)
    private City doctorCity;

    @Column(name = "Speciality")
    @Enumerated(EnumType.STRING)
    private Speciality doctorSpeciality;
}
