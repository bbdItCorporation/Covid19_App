package com.bbd.Covid19_App.controllers;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.entities.User;
import com.bbd.Covid19_App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String registerUser(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "user_pages/newUserForm.html";
    }


    @PostMapping("/register/save")
    public String savePatient(@Valid @ModelAttribute("newUser") User user, Errors errors, Authentication authentication) {

        if (errors.hasErrors()) {
            return "user_pages/newUserForm.html";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/";
    }
}
