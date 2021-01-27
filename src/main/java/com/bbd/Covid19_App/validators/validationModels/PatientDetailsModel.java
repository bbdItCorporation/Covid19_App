package com.bbd.Covid19_App.validators.validationModels;


import com.bbd.Covid19_App.entities.Patient;

import java.time.LocalDate;
import java.time.Period;


public class PatientDetailsModel {

    private Integer patientId;
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthDate;
    private int age;
    private LocalDate datePositive;
    private LocalDate dateInformation;
    private String residenceCity;
    private String residenceDistrict;
    private String residenceApartmentNumber;
    private String stayApartmentNumber;
    private String stayStreet;
    private String residenceStreet;
    private String stayCityCode;
    private String residenceCityCode;
    private String stayCity;
    private String stayDistrict;
    private String hospitalName;
    private Boolean hospitalized;
    private Boolean inQuarantine;
    private Boolean supervision;
    private String labName;
    private String infectionSource;
    private String phoneNumber;
    private String email;
    private String creatorLogin;


    public PatientDetailsModel() {
    }

    public PatientDetailsModel(Patient patient) {
        this.patientId = patient.getPatientId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.gender = patient.getGender();
        this.birthDate = patient.getBirthDate();
        this.age = patient.getAge();
        this.datePositive = patient.getDatePositive();
        this.dateInformation = patient.getDateInformation();
        this.residenceCity = patient.getResidenceCity();
        this.residenceDistrict = patient.getResidenceDistrict();
        this.residenceApartmentNumber = patient.getResidenceApartmentNumber();
        this.stayApartmentNumber = patient.getStayApartmentNumber();
        this.stayCityCode = patient.getStayCityCode();
        this.residenceCityCode = patient.getResidenceCityCode();
        this.stayStreet = patient.getStayStreet();
        this.residenceStreet = patient.getResidenceStreet();
        this.stayCity = patient.getStayCity();
        this.stayDistrict = patient.getStayDistrict();
        this.hospitalized = patient.getHospitalized();
        this.hospitalName = patient.getHospitalName();
        this.inQuarantine = patient.getInQuarantine();
        this.supervision = patient.getSupervision();
        this.labName = patient.getLabName();
        this.infectionSource = patient.getInfectionSource();
        this.phoneNumber = patient.getPhoneNumber();
        this.email = patient.getEmail();
        this.creatorLogin = patient.getCreator().getLogin();
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
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

    public String getResidenceApartmentNumber() {
        return residenceApartmentNumber;
    }

    public void setResidenceApartmentNumber(String residenceApartmentNumber) {
        this.residenceApartmentNumber = residenceApartmentNumber;
    }

    public String getStayApartmentNumber() {
        return stayApartmentNumber;
    }

    public void setStayApartmentNumber(String stayApartmentNumber) {
        this.stayApartmentNumber = stayApartmentNumber;
    }

    public String getStayStreet() {
        return stayStreet;
    }

    public void setStayStreet(String stayStreet) {
        this.stayStreet = stayStreet;
    }

    public String getResidenceStreet() {
        return residenceStreet;
    }

    public void setResidenceStreet(String residenceStreet) {
        this.residenceStreet = residenceStreet;
    }

    public String getStayCityCode() {
        return stayCityCode;
    }

    public void setStayCityCode(String stayCityCode) {
        this.stayCityCode = stayCityCode;
    }

    public String getResidenceCityCode() {
        return residenceCityCode;
    }

    public void setResidenceCityCode(String residenceCityCode) {
        this.residenceCityCode = residenceCityCode;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatorLogin() {
        return creatorLogin;
    }

    public void setCreatorLogin(String creatorLogin) {
        this.creatorLogin = creatorLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}