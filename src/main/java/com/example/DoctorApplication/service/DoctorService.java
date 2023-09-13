package com.example.DoctorApplication.service;

import com.example.DoctorApplication.model.City;
import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.model.Speciality;
import com.example.DoctorApplication.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo doctorRepo ;

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }


    public boolean exist(Long id) {
        return doctorRepo.existsById(id);
    }

    public void deleteDoctorById(Long id) {
        doctorRepo.deleteById(id);
    }

    public List<Doctor> getDoctorsByLocationAndSpeciality(City city, Speciality patientSpeciality) {
        return doctorRepo.findAllByDoctorCityAndDoctorSpeciality(city , patientSpeciality);
    }
}
