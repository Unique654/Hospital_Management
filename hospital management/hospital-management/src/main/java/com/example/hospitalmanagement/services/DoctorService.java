package com.example.hospitalmanagement.services;

import com.example.hospitalmanagement.entities.Doctor;
import com.example.hospitalmanagement.enums.Speciality;
import com.example.hospitalmanagement.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class DoctorService {

        @Autowired
        private DoctorRepository doctorRepository;

        public Doctor addDoctor(Doctor doctor) {
            return doctorRepository.save(doctor);
        }

        public List<Doctor> getDoctorsByCityAndSpeciality(String city, Speciality speciality) {
            return doctorRepository.findByCityAndSpeciality(city, speciality);
        }
    }

