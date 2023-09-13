package com.example.DoctorApplication.repository;

import com.example.DoctorApplication.model.City;
import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor , Long> {
    List<Doctor> findAllByDoctorCityAndDoctorSpeciality(City city, Speciality patientSpeciality);


}
