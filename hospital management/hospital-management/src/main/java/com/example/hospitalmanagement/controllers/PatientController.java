package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.entities.Patient;
import com.example.hospitalmanagement.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/patients")
    public class PatientController {

        @Autowired
        private PatientService patientService;

        @PostMapping
        public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) {
            Patient Patient;
            return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
        }
    }

