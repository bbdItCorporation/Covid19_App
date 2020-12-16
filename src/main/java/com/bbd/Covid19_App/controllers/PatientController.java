package com.bbd.Covid19_App.controllers;


import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.entities.User;
import com.bbd.Covid19_App.services.PatientService;
import com.bbd.Covid19_App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.validation.Valid;


@Controller
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    PatientService patientService;

    @Autowired
    UserService userService;

    @GetMapping("/new")
    public String displayPatientForm(Model model) {
        Patient newPatient = new Patient();
        model.addAttribute("newPatient", newPatient);
        return "patient_pages/newPatientForm.html";
    }


    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("newPatient") Patient patient, Errors errors, Authentication authentication) {

        if (errors.hasErrors()) {
            return "patient_pages/newPatientForm.html";
        }

        String login = authentication.getName();
        User currentUser = userService.findByLogin(login);

        patient.setCreator(currentUser);
        patient.setAge();
        patientService.save(patient);
        return "redirect:/";
    }

//    TODO: add method to display patients list (TOP 10) - @GetMapping("/search")
//    TODO: add methods to display patients by criteria - @GetMapping("/searchAllByCriteria")
//    TODO: add method to display details of specific patient- @GetMapping("/details/{id}")
//    TODO: add method to display details of specific patient- @GetMapping("/edit/{id}")
//    TODO: add method to display details of specific patient- @GetMapping("/edited/{id}")

}
