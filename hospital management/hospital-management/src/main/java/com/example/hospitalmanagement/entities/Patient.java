package com.example.hospitalmanagement.entities;

import com.example.hospitalmanagement.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(min = 3)
        private String name;

        @Size(max = 20)
        private String city;

        @Email
        private String email;

        @Size(min = 10)
        private String phoneNumber;

        @Enumerated(EnumType.STRING)
        private Symptom symptom;

    public String getCity() {
        return city;
    }

    public Symptom getSymptom() {
        return symptom;
    }
}
