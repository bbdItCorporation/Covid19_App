package com.bbd.Covid19_App.controllers;


import com.bbd.Covid19_App.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    PatientService patientService;

    @GetMapping()
    public String displayHomePage(Model model) {
        model.addAttribute("listOfPatients", patientService.findAll());
        return "home_pages/homePage";
    }
}
