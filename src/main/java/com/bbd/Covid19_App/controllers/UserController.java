package com.bbd.Covid19_App.controllers;



import com.bbd.Covid19_App.docGenerators.WordGenerator;
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
import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=PSSEExcelReport_" + LocalDate.now() + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Patient> patients = patientService.findAll();

        ExcelGenerator excelGenerator = new ExcelGenerator(patients);
        excelGenerator.export(response);
    }

    @GetMapping("patient/export/word/{patientId}")
    public void exportWordDoc(@PathVariable("patientId") Integer patientId, HttpServletResponse response) throws IOException {

        Patient patient = patientService.findByPatientId(patientId);
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ZawiadomienieKwarantanna_" + patient.getSurname() + "_" + patient.getName() + ".doc";
        response.setHeader(headerKey, headerValue);

        try {
            WordGenerator wordGenerator = new WordGenerator(patient, "src/main/java/com/bbd/Covid19_App/docGenerators/wordDoc.doc");
            wordGenerator.export(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
