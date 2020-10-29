package com.bbd.Covid19_App.services;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService  {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        List<Patient> allPatients = patientRepository.findAll();
        return allPatients;
    }

}
