package com.bbd.Covid19_App.controllers;

import com.bbd.Covid19_App.entities.User;
import com.bbd.Covid19_App.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    TODO: add validation for a password and login
    @PostMapping("/register/save")
    public String saveNewUser(Model model, User newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userService.save(newUser);
        return "redirect:/";
    }
}
