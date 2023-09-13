package com.example.DoctorApplication.controller;

import com.example.DoctorApplication.model.*;
import com.example.DoctorApplication.service.DoctorService;
import com.example.DoctorApplication.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientService patientService ;

    @Autowired
    DoctorService doctorService ;

    @PostMapping("add")
    public ResponseEntity<String> createPatient(@Valid @RequestBody Patient patient){
        HttpStatus status ;
        String response ;

        try {
            patientService.addPatient(patient) ;
            status = HttpStatus.OK ;
            response = "Patient Created Successfully" ;
        }
        catch (Exception e){
            status = HttpStatus.BAD_REQUEST ;
            response = "Something went wrong" ;
        }
        return ResponseEntity.status(status).body(response) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id){
        HttpStatus status ;
        String response ;

        try {
            if(patientService.exist(id)){
            patientService.deletePatientById(id);
            status = HttpStatus.OK ;
            response = "Patient deleted Successfully" ;
            }else{
                status = HttpStatus.BAD_REQUEST ;
                response = "Patient Id does not exists" ;
            }
        }
        catch (Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR ;
            response = "Something went wrong .........." ;
        }
        return ResponseEntity.status(status).body(response) ;
    }

    @GetMapping("getDoctor/{id}")
    public ResponseEntity<List<Doctor>> suggestDoctor(@PathVariable Long id){
            Optional<Patient> optionalPatient = patientService.findById(id);
            if(optionalPatient.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Patient patient = optionalPatient.get();
            City city = City.valueOf(patient.getPatientCity());
            Speciality patientSpeciality = getSpecialityBySymptoms(patient.getPatientSymptom());
            List<Doctor> suggestedDoctors = doctorService.getDoctorsByLocationAndSpeciality(city , patientSpeciality);
            return ResponseEntity.status(HttpStatus.OK).body(suggestedDoctors);
    }

    private Speciality getSpecialityBySymptoms(Symptoms symptom) {
        if(symptom == Symptoms.ARTHRITIS || symptom == Symptoms.BACK_PAIN || symptom == Symptoms.TISSUE_INJURIES){
            return Speciality.ORTHOPEDIC ;
        }
        else if(symptom == Symptoms.DYSMENORRHEA){
            return Speciality.GYNECOLOGY ;
        }
        else if(symptom == Symptoms.SKIN_INFECTION || symptom == Symptoms.SKIN_BURN){
            return Speciality.DERMATOLOGY ;
        }
        else if (symptom == Symptoms.EAR_PAIN)  {
            return Speciality.ENT_SPECIALIST ;
        }
        else {
            return null ;
        }

    }


}
