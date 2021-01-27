package com.bbd.Covid19_App.validators.validationModels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserEditModel {

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    private String name;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ-]+$", message = "Pole może zawierać tylko małe, duże litery lub \"-\".")
    private String surname;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "(user|admin)", message = "Pole wymagane.")
    private String role;

    private Boolean enabled;


    public UserEditModel(String name, String surname, String role, Boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
