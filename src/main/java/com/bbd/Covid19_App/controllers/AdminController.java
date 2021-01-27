package com.bbd.Covid19_App.controllers;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.entities.User;
import com.bbd.Covid19_App.services.PatientService;
import com.bbd.Covid19_App.services.UserService;
import com.bbd.Covid19_App.validators.validationModels.UserEditModel;
import com.bbd.Covid19_App.validators.validationModels.UserEditPasswordModel;
import com.bbd.Covid19_App.validators.validationModels.UserFilterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    @GetMapping("/register")
    public String registerUser(Model model, Authentication authentication) {
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

    @GetMapping("/users")
    public String getAllUsers(Model model, Authentication authentication) {
        List<User> users = userService.searchForUsers("","","","user",true);
        model.addAttribute("users", users);

        User userToSearch = new User();
        model.addAttribute("userToSearch", userToSearch);

        return "user_pages/usersDisplayForm.html";
    }


    @PostMapping("/users/search")
    public String getAllUserSearched(@ModelAttribute("userToSearch") @Valid UserFilterModel userFilterModel, Errors errors, Authentication authentication, Model model) {

        if (errors.hasErrors()) {
            return "user_pages/usersDisplayForm.html";
        }

        List<User> foundUsers = userService.searchForUsers(userFilterModel.getName(), userFilterModel.getSurname(), userFilterModel.getLogin(), userFilterModel.getRole(), userFilterModel.getEnabled());

        model.addAttribute("users", foundUsers);
        return "user_pages/usersDisplayForm.html";

    }

    @GetMapping("/users/search")
    public String returnToAllUsers(Model model) {
        return "redirect:/admin/users";
    }

    @GetMapping("/user/details/{userId}")
    public String getUserDetails(@PathVariable("userId") Integer userId, Model model) {
        User selectedUser = userService.findByUserId(userId);

        if (selectedUser != null) {
            model.addAttribute("selectedUser", selectedUser);
            return "user_pages/patientDetailsForm.html";
        }

        return "error_pages/error404.html";
    }


    @GetMapping("/user/edit/{userId}")
    public String editUser(@PathVariable("userId") Integer userId, Model model) {
        User userToBeEdited = userService.findByUserId(userId);

        if (userToBeEdited != null) {
            model.addAttribute("userToBeEdited", userToBeEdited);
            return "user_pages/userEditForm.html";
        }

        return "error_pages/error404.html";
    }


    @PostMapping("/user/edited/{userId}")
    public String updatePatient(@PathVariable("userId") Integer userId, @ModelAttribute("userToBeEdited") @Valid UserEditModel userEditModel, Errors errors, Authentication authentication) {

        if (errors.hasErrors()) {
            return "user_pages/userEditForm.html";

        }

        User userToEdit = userService.findByUserId(userId);
        userToEdit.setName(userEditModel.getName());
        userToEdit.setSurname(userEditModel.getSurname());
        userToEdit.setRole(userEditModel.getRole());
        userToEdit.setEnabled(userEditModel.getEnabled());

        userService.save(userToEdit);
        return "redirect:/admin/user/details/" + Integer.toString(userId);
    }


    @GetMapping("/user/edit/password/{userId}")
    public String editPassUser(@PathVariable("userId") Integer userId, Model model, Authentication authentication) {
        User userPassEdited = userService.findByUserId(userId);

        if (userPassEdited != null) {
            UserEditPasswordModel userEditPasswordModel = new UserEditPasswordModel(userPassEdited.getUserId(), "");
            model.addAttribute("userPassEdited", userEditPasswordModel);
            return "user_pages/userEditPasswordForm.html";
        }

        return "error_pages/error404.html";
    }


    @PostMapping("/user/edited/password/{userId}")
    public String updatePassUser(@PathVariable("userId") Integer userId, @ModelAttribute("userPassEdited")  @Valid UserEditPasswordModel userEditPasswordModel, Errors errors, Authentication authentication) {


        if (errors.hasErrors()) {
            return "user_pages/userEditPasswordForm.html";
        }

        User userToEditPassword = userService.findByUserId(userId);
        userToEditPassword.setPassword(bCryptPasswordEncoder.encode(userEditPasswordModel.getPassword()));
        userService.save(userToEditPassword);
        return "redirect:/admin/user/details/" + Integer.toString(userId);
    }

    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId, Model model, Authentication authentication) {

        User userToBeDeleted = userService.findByUserId(userId);
        List<Patient> createdPatients = patientService.findAllByCreator(userToBeDeleted);


        if (authentication.getName().equals(userToBeDeleted.getLogin())) {
            return "error_pages/errorThisIsCurrentUser.html";
        }

        if (createdPatients.isEmpty()) {
            userService.deleteByUserId(userId);
            return "redirect:/admin/users";
        }

        userToBeDeleted.setEnabled(false);
        userService.save(userToBeDeleted);
        model.addAttribute("userCannotBeDeleted", userId);
        return "error_pages/errorUserCannotBeDeleted.html";
    }

}
