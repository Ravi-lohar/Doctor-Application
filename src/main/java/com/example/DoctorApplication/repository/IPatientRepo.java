package com.example.DoctorApplication.repository;

import com.example.DoctorApplication.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient, Long> {
}
