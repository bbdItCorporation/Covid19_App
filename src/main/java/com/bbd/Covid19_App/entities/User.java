package com.bbd.Covid19_App.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "dbo", name = "covid_users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

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
