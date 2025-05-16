package com.example.hospitalmanagement.entities;

import com.example.hospitalmanagement.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

//        @NotBlank
        @Pattern(regexp = "^[A-Za-z .'-]+$", message = "Name must contain only letters, spaces, dots, apostrophes or hyphens")
        @Size(min = 3)
        private String name;

        @Size(max = 20)
        private String city;

        @Email
        private String email;

        @Size(min = 10)

        private String phoneNumber;

        @Enumerated(EnumType.STRING)
        private Speciality speciality;
}
