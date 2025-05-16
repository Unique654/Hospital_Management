package com.example.hospitalmanagement.utils;

import com.example.hospitalmanagement.enums.Speciality;
import com.example.hospitalmanagement.enums.Symptom;
import java.util.HashMap;
import java.util.Map;

    public class SymptomToSpecialityMapper {
        private static final Map<Symptom, Speciality> map = new HashMap<>();

        static {
            map.put(Symptom.ARTHRITIS, Speciality.ORTHOPAEDIC);
            map.put(Symptom.BACK_PAIN, Speciality.ORTHOPAEDIC);
            map.put(Symptom.TISSUE_INJURIES, Speciality.ORTHOPAEDIC);
            map.put(Symptom.DYSMENORRHEA, Speciality.GYNECOLOGY);
            map.put(Symptom.SKIN_BURN, Speciality.DERMATOLOGY);
            map.put(Symptom.SKIN_INFECTION, Speciality.DERMATOLOGY);
            map.put(Symptom.EAR_PAIN, Speciality.ENT);
        }

        public static Speciality getSpeciality(Symptom symptom) {
            return map.get(symptom);
        }
    }

