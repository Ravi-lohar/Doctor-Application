package com.example.DoctorApplication.service;

import com.example.DoctorApplication.model.Patient;
import com.example.DoctorApplication.repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo ;

    public void addPatient(Patient patient) {
       patientRepo.save(patient);
    }

    public void deletePatientById(Long id) {
        patientRepo.deleteById(id);
    }

    public boolean exist(Long id) {
        return patientRepo.existsById(id);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepo.findById(id);
    }
}
