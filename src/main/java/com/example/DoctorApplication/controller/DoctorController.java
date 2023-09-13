package com.example.DoctorApplication.controller;

import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService ;

    @PostMapping("add")
    public ResponseEntity<String> createDoctor(@Valid @RequestBody Doctor doctor){
        HttpStatus status ;
        String response ;

        try {
            doctorService.addDoctor(doctor) ;
            status = HttpStatus.OK ;
            response = "Doctor Id Created Successfully" ;
        }
        catch (Exception e){
            status = HttpStatus.BAD_REQUEST ;
            response = "Something went wrong" ;
        }
        return ResponseEntity.status(status).body(response) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id){
        HttpStatus status ;
        String response ;

        try {
            if(doctorService.exist(id)){
                doctorService.deleteDoctorById(id);
                status = HttpStatus.OK ;
                response = "Doctor deleted Successfully" ;
            }else{
                status = HttpStatus.BAD_REQUEST ;
                response = "Doctor Id does not exists" ;
            }
        }
        catch (Exception e){
            status = HttpStatus.INTERNAL_SERVER_ERROR ;
            response = "Something went wrong .........." ;
        }
        return ResponseEntity.status(status).body(response) ;
    }

}
