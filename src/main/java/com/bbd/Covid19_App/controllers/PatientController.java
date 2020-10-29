package com.bbd.Covid19_App.controllers;


import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/new")
    public String displayPatientForm(Model model) {
        Patient newPatient = new Patient();
        model.addAttribute("newPatient", newPatient);
        return "patientFormPage";
    }


    @PostMapping("/save")
    public String savePatient(Patient patient, Model model) {
        patient.setAge();
        patientRepository.save(patient);
        return "redirect:/";
    }




}
