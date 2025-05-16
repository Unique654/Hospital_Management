package com.example.hospitalmanagement.repositories;

import com.example.hospitalmanagement.entities.Doctor;
import com.example.hospitalmanagement.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}

