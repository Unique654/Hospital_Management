package com.example.hospitalmanagement.controllers;

import com.example.hospitalmanagement.entities.Doctor;
import com.example.hospitalmanagement.services.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/suggest")
    public class SuggestController {

        @Autowired
        private SuggestionService suggestionService;

        @GetMapping("/{patientId}")
        public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
            try {
                List<Doctor> doctors = suggestionService.suggestDoctors(patientId);
                return new ResponseEntity<>(doctors, HttpStatus.OK);
            } catch (IllegalStateException e) {
                return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(Map.of("message", "Unexpected error: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }