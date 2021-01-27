package com.bbd.Covid19_App.validators.validationModels;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class UserFilterModel {


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$|^$", message = "Pole może zawierać tylko małe i duże litery.")
    private String name;


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ-]+$|^$", message = "Pole może zawierać tylko małe, duże litery lub \"-\".")
    private String surname;


    @Pattern(regexp = "^[a-złęóąśżźćń0-9_#]+$|^$", message =  "Podany login zawiera nieprawidłowe znaki.")
    @Column(name = "login")
    private String login;

    @Pattern(regexp = "(user|admin|)", message = "Pole wymagane.")
    private String role;

    private Boolean enabled;


    public UserFilterModel(String name, String surname, String login, String role, Boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
