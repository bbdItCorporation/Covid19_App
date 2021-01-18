package com.bbd.Covid19_App.controllers;



import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.docGenerators.ExcelGenerator;
import com.bbd.Covid19_App.services.PatientService;
import com.bbd.Covid19_App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    @GetMapping("/login")
    public String login() {
        return "user_pages/loginForm.html";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=patientExcelReport.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Patient> patients = patientService.findAll();

        ExcelGenerator excelGenerator = new ExcelGenerator(patients);
        excelGenerator.export(response);
    }

//    TODO: method to display all users
//    TODO: method to search by name and surname and value of enabled

}
