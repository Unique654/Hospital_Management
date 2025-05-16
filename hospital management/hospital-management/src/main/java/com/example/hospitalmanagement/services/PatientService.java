package com.example.hospitalmanagement.services;

import com.example.hospitalmanagement.entities.Patient;
import com.example.hospitalmanagement.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class PatientService {

        @Autowired
        private PatientRepository patientRepository;

        public Patient addPatient(Patient patient) {
            return patientRepository.save(patient);
        }

        public Optional<Patient> getPatientById(Long id) {
            return patientRepository.findById(id);
        }
    }

