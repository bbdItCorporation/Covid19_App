package com.bbd.Covid19_App.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table(schema = "dbo", name = "covid_people")
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @NotBlank(message = "Pole wymagane.")
//    @Pattern(regexp = ".*([a-zA-Z]{4}$)")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Length(max=50)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-Z-]+$")
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(name = "sex")
    private String gender;

//    TODO: add validation for dates
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "age")
    private int age;

    @Column(name = "date_positive")
    private LocalDate datePositive;
    
    @Column(name = "date_information")
    private LocalDate dateInformation;
    
    @Column(name = "residence_city")
    private String residenceCity;
    
    @Column(name = "residence_district")
    private String residenceDistrict;
    
    @Column(name = "stay_city")
    private String stayCity;
    
    @Column(name = "stay_district")
    private String stayDistrict;

    @Column(name = "hospitalized")
    private Boolean hospitalized;

    @Column(name = "hospital_name")
    private String hospitalName;
    
    @Column(name = "quarantine")
    private Boolean inQuarantine;

    @Column(name = "supervision")
    private Boolean supervision;

    @Column(name = "laboratory")
    private String labName;

    @Column(name = "infection_source")
    private String infectionSource;

    @Column(name = "telephone_number")
    private Integer phoneNumber;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
               fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;


    public Patient() {
    }

    public Patient(String name, String surname, String gender, LocalDate birthDate, int age, LocalDate datePositive, LocalDate dateInformation, String residenceCity, String residenceDistrict, String stayCity, String stayDistrict, Boolean hospitalized, String hospitalName, Boolean inQuarantine, Boolean supervision, String labName, String infectionSource, int phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.datePositive = datePositive;
        this.dateInformation = dateInformation;
        this.residenceCity = residenceCity;
        this.residenceDistrict = residenceDistrict;
        this.stayCity = stayCity;
        this.stayDistrict = stayDistrict;
        this.hospitalized = hospitalized;
        this.hospitalName = hospitalName;
        this.inQuarantine = inQuarantine;
        this.supervision = supervision;
        this.labName = labName;
        this.infectionSource = infectionSource;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return patientId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = this.calculateAge();
    }

    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(this.birthDate, currentDate).getYears();
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDatePositive() {
        return datePositive;
    }

    public void setDatePositive(LocalDate datePositive) {
        this.datePositive = datePositive;
    }

    public LocalDate getDateInformation() {
        return dateInformation;
    }

    public void setDateInformation(LocalDate dateInformation) {
        this.dateInformation = dateInformation;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceDistrict() {
        return residenceDistrict;
    }

    public void setResidenceDistrict(String residenceDistrict) {
        this.residenceDistrict = residenceDistrict;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity;
    }

    public String getStayDistrict() {
        return stayDistrict;
    }

    public void setStayDistrict(String stayDistrict) {
        this.stayDistrict = stayDistrict;
    }

    public Boolean getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(Boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Boolean getInQuarantine() {
        return inQuarantine;
    }

    public void setInQuarantine(Boolean inQuarantine) {
        this.inQuarantine = inQuarantine;
    }

    public Boolean getSupervision() {
        return supervision;
    }

    public void setSupervision(Boolean supervision) {
        this.supervision = supervision;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getInfectionSource() {
        return infectionSource;
    }

    public void setInfectionSource(String infectionSource) {
        this.infectionSource = infectionSource;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
