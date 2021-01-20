package com.bbd.Covid19_App.entities;

import com.bbd.Covid19_App.validators.UniqueLogin;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(schema = "dbo", name = "covid_users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ-]+$", message = "Pole może zawierać tylko małe, duże litery lub \"-\".")
    @Column(name = "surname")
    private String surname;

    @UniqueLogin(message = "Podany login jest już zajęty.")
    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-złęóąśżźćń0-9_#]+$", message =  "Podany login zawiera nieprawidłowe znaki.")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ0-9_#]+$", message = "Hasło zawiera nieprawidłowe znaki.")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Pole wymagane.")
    @Length(min=3, message="Pole wymagane.")
    @Pattern(regexp = "(user|admin)", message = "Pole wymagane.")
    @Column(name = "role")
    private String role = "user"; // TODO: field while adding new users to choose role: admin or user

    @Column(name = "enabled")
    private Boolean enabled = true;

    @OneToMany(mappedBy = "creator")
    private List<Patient> patients;

    public User() {
    }

    public User(String userName, String surname, String login, String password, String role) {
        this.name = userName;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
