package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.entities.Doctor;
import com.example.hospitalmanagement.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/doctors")
    public class DoctorController {

        @Autowired
        private DoctorService doctorService;

        @PostMapping
        public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
            return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
        }
    }

