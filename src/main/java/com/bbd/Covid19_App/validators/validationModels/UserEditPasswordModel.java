package com.bbd.Covid19_App.validators.validationModels;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserEditPasswordModel {

    private Integer userId;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ0-9_#]+$", message = "Hasło zawiera nieprawidłowe znaki.")
    @Column(name = "password")
    private String password;

    public UserEditPasswordModel(Integer userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
