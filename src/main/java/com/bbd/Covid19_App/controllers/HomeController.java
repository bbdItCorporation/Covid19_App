package com.bbd.Covid19_App.controllers;

import com.bbd.Covid19_App.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/")
    public String getAllPatients(Model model) {

        model.addAttribute("listOfPatients", patientRepository.findAll());
        return "homePage";
    }
}
