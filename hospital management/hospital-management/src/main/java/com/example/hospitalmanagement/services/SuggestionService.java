package com.example.hospitalmanagement.services;

import com.example.hospitalmanagement.entities.Doctor;
import com.example.hospitalmanagement.entities.Patient;
import com.example.hospitalmanagement.enums.Speciality;
import com.example.hospitalmanagement.repositories.DoctorRepository;
import com.example.hospitalmanagement.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

    @Service
    public class SuggestionService {

        @Autowired
        private DoctorRepository doctorRepository;

        @Autowired
        private PatientRepository patientRepository;

        public List<Doctor> suggestDoctors(Long patientId) {
            Optional<Patient> optionalPatient = patientRepository.findById(patientId);

            if (optionalPatient.isEmpty()) {
                throw new RuntimeException("Patient not found");
            }

            Patient patient = optionalPatient.get();
            String city = patient.getCity();
            String symptom = patient.getSymptom().name(); // Assuming enum
            Speciality requiredSpeciality = SymptomToSpecialityMapper.getSpeciality(patient.getSymptom());

            if (!List.of("Delhi", "Noida", "Faridabad").contains(city)) {
                throw new IllegalStateException("We are still waiting to expand to your location");
            }

            List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, requiredSpeciality);
            if (doctors.isEmpty()) {
                throw new IllegalStateException("There isn’t any doctor present at your location for your symptom");
            }

            return doctors;
        }
    }

