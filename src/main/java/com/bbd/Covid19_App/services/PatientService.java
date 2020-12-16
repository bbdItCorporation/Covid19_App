package com.bbd.Covid19_App.services;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService  {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    // if own quesry add method here
}
