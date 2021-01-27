package com.bbd.Covid19_App.controllers;


import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.entities.User;
import com.bbd.Covid19_App.services.PatientService;
import com.bbd.Covid19_App.services.UserService;
import com.bbd.Covid19_App.validators.validationModels.PatientDetailsModel;
import com.bbd.Covid19_App.validators.validationModels.PatientFilterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.validation.Valid;
import java.util.List;


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

        currentUser.getPatients().add(patient);

        return "redirect:/";
    }

    @GetMapping("/details/{patientId}")
    public String getPatientDetails(@PathVariable("patientId") Integer patientId, Model model) {
        Patient selectedPatient = patientService.findByPatientId(patientId);

        if (selectedPatient != null) {
            PatientDetailsModel patientDetailsModel = new PatientDetailsModel(selectedPatient);
            model.addAttribute("selectedPatient", patientDetailsModel);
            return "patient_pages/patientDetailsForm.html";
        }

        return "error_pages/error404.html";
    }

    @GetMapping("/edit/{patientId}")
    public String editUser(@PathVariable("patientId") Integer patientId, Model model) {
        Patient patientToBeEdited = patientService.findByPatientId(patientId);

        if (patientToBeEdited != null) {
            model.addAttribute("patientToBeEdited", patientToBeEdited);
            return "patient_pages/patientEditForm.html";
        }

        return "error_pages/error404.html";
    }

    @PostMapping("/edited/{patientId}")
    public String updatePatient(@PathVariable("patientId") Integer patientId, @ModelAttribute("patientToBeEdited") @Valid Patient patient, Errors errors, Authentication authentication) {

        if (errors.hasErrors()) {
            return "patient_pages/patientEditForm.html";

        }

        String login = authentication.getName();
        User currentUser = userService.findByLogin(login);
        patient.setCreator(currentUser);

        patient.setPatientId(patientId);
        patientService.save(patient);

        currentUser.getPatients().add(patient);
        return "redirect:/patient/details/" + Integer.toString(patientId);
    }


    @GetMapping("/all")
    public String getAllPatients(Model model, Authentication authentication) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);

        PatientFilterModel patientToSearch = new PatientFilterModel();
        model.addAttribute("patientToSearch", patientToSearch);
        return "patient_pages/patientsDisplayForm.html";
    }

    @GetMapping("/all/search")
    public String returnToAllUsers(Model model) {
        return "redirect:/all";
    }


    @PostMapping("/all/search")
    public String getAllPatientsSearched(@ModelAttribute("patientToSearch") @Valid PatientFilterModel patientFilterModel, Errors errors, Authentication authentication, Model model) {

        if (errors.hasErrors()) {
            return "patient_pages/patientsDisplayForm.html";
        }

        List<Patient> foundPatients = patientService.findAllByEverything(patientFilterModel.getName(),
                                                                         patientFilterModel.getSurname(),
                                                                         patientFilterModel.getGender(),
                                                                         patientFilterModel.getBirthDateFrom(),
                                                                         patientFilterModel.getBirthDateTo(),
                                                                         GetIntegerFromString(patientFilterModel.getAgeFrom()),
                                                                         GetIntegerFromString(patientFilterModel.getAgeTo()),
                                                                         patientFilterModel.getDatePositiveFrom(),
                                                                         patientFilterModel.getDatePositiveTo(),
                                                                         patientFilterModel.getDateInformationFrom(),
                                                                         patientFilterModel.getDateInformationTo(),
                                                                         patientFilterModel.getResidenceStreet(),
                                                                         patientFilterModel.getResidenceCityCode(),
                                                                         patientFilterModel.getResidenceCity(),
                                                                         patientFilterModel.getResidenceDistrict(),
                                                                         patientFilterModel.getStayStreet(),
                                                                         patientFilterModel.getStayCityCode(),
                                                                         patientFilterModel.getStayCity(),
                                                                         patientFilterModel.getStayDistrict(),
                                                                         patientFilterModel.getHospitalName(),
                                                                         patientFilterModel.getHospitalized(),
                                                                         patientFilterModel.getInQuarantine(),
                                                                         patientFilterModel.getSupervision(),
                                                                         patientFilterModel.getLabName(),
                                                                         patientFilterModel.getInfectionSource(),
                                                                         patientFilterModel.getPhoneNumber(),
                                                                         patientFilterModel.getEmail(),
                                                                         patientFilterModel.getCreatorLogin());

        model.addAttribute("patients", foundPatients);
        return "patient_pages/patientsDisplayForm.html";
    }

    @GetMapping("/delete/{patientId}")
    public String deleteUser(@PathVariable("patientId") Integer patientId, Model model, Authentication authentication) {
        patientService.deleteByPatientId(patientId);

        return "redirect:/patient/all";
    }

    private Integer GetIntegerFromString(final String s) {
        if (s.isEmpty()) {
            return null;
        } else {
            return Integer.valueOf(s);
        }
    }

}
