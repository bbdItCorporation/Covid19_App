package com.bbd.Covid19_App.validators.validationModels;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class PatientFilterModel {

    private Integer patientId;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String name;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ-]*$", message = "Pole może zawierać tylko małe, duże litery lub \"-\".")
    private String surname;

    @Pattern(regexp = "(M|K|)", message = "Błędne dane.")
    private String gender;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDateFrom;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDateTo;


    @Pattern(regexp = "^[0-9]*$", message = "Pole moża zawierać jedynie cyfry dodatnie.")
    private String ageFrom;

    @Pattern(regexp = "^[0-9]*$", message = "Pole moża zawierać jedynie cyfry dodatnie.")
    private String ageTo;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePositiveFrom;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePositiveTo;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateInformationFrom;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateInformationTo;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆ Ń-]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String residenceCity;


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String residenceDistrict;


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆ Ń-]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String stayCity;


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String stayDistrict;


    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ .-]*$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "stay_street")
    private String stayStreet;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ .-]*$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "residence_street")
    private String residenceStreet;

    @Pattern(regexp = "^[0-9a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ/]*$", message = "Pole może zawierać tylko cyfry, małe, duże litery lub znak \"/\".")
    @Column(name = "stay_apartment_number")
    private String stayApartmentNumber;

    @Pattern(regexp = "^[0-9a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ/]*$", message = "Pole może zawierać tylko cyfry, małe, duże litery lub znak \"/\".")
    @Column(name = "residence_apartment_number")
    private String residenceApartmentNumber;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String hospitalName;

    private Boolean hospitalized;

    private Boolean inQuarantine;

    private Boolean supervision;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String labName;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    private String infectionSource;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$|^[0-9]{0,3}$", message = "Pole może zawierać pełny kod lub maksymalnie 3 kolejne cyfry, nieoddzielone myślnikiem.")
    private String residenceCityCode;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$|^[0-9]{0,3}$", message = "Pole może zawierać pełny kod lub maksymalnie 3 kolejne cyfry, nieoddzielone myślnikiem.")
    private String stayCityCode;

    @Pattern(regexp = "^[0-9]{9}$|^$", message = "Błędny numer telefonu.")
    private String phoneNumber;

    @Email(message = "Błędny adres email.")
    private String email;

    @Pattern(regexp = "^[a-złęóąśżźćń0-9_#]*$", message =  "Podany login zawiera nieprawidłowe znaki.")
    private String creatorLogin;


    public PatientFilterModel() {

    }
    public PatientFilterModel(Integer patientId, String stayCityCode, String residenceCityCode, String name, String stayApartmentNumber, String stayStreet, String residenceApartmentNumber, String residenceStreet, String surname, String gender, LocalDate birthDateFrom, LocalDate birthDateTo,  String ageFrom, String ageTo,  LocalDate datePositiveFrom, LocalDate datePositiveTo,  LocalDate dateInformationFrom, LocalDate dateInformationTo,  String residenceCity,  String residenceDistrict,  String stayCity,  String stayDistrict,  String hospitalName, Boolean hospitalized, Boolean inQuarantine, Boolean supervision, String labName, String infectionSource,  String phoneNumber, String email, String creatorLogin) {
        this.patientId = patientId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDateFrom = birthDateFrom;
        this.birthDateTo = birthDateTo;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.datePositiveFrom = datePositiveFrom;
        this.residenceApartmentNumber = residenceApartmentNumber;
        this.stayApartmentNumber = stayApartmentNumber;
        this.stayCityCode = stayCityCode;
        this.residenceCityCode = residenceCityCode;
        this.stayStreet = stayStreet;
        this.residenceStreet = residenceStreet;
        this.datePositiveTo = datePositiveTo;
        this.dateInformationFrom = dateInformationFrom;
        this.dateInformationTo = dateInformationTo;
        this.residenceCity = residenceCity;
        this.residenceDistrict = residenceDistrict;
        this.stayCity = stayCity;
        this.stayDistrict = stayDistrict;
        this.hospitalName = hospitalName;
        this.hospitalized = hospitalized;
        this.inQuarantine = inQuarantine;
        this.supervision = supervision;
        this.labName = labName;
        this.infectionSource = infectionSource;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creatorLogin = creatorLogin;
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

    public LocalDate getBirthDateFrom() {
        return birthDateFrom;
    }

    public void setBirthDateFrom(LocalDate birthDateFrom) {
        this.birthDateFrom = birthDateFrom;
    }

    public LocalDate getBirthDateTo() {
        return birthDateTo;
    }

    public void setBirthDateTo(LocalDate birthDateTo) {
        this.birthDateTo = birthDateTo;
    }

    public LocalDate getDatePositiveTo() {
        return datePositiveTo;
    }

    public void setDatePositiveTo(LocalDate datePositiveTo) {
        this.datePositiveTo = datePositiveTo;
    }

    public LocalDate getDateInformationTo() {
        return dateInformationTo;
    }

    public void setDateInformationTo(LocalDate dateInformationTo) {
        this.dateInformationTo = dateInformationTo;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public String getResidenceCityCode() {
        return residenceCityCode;
    }

    public void setResidenceCityCode(String residenceCityCode) {
        this.residenceCityCode = residenceCityCode;
    }

    public String getStayCityCode() {
        return stayCityCode;
    }

    public void setStayCityCode(String stayCityCode) {
        this.stayCityCode = stayCityCode;
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

    public String getStayApartmentNumber() {
        return stayApartmentNumber;
    }

    public void setStayApartmentNumber(String stayApartmentNumber) {
        this.stayApartmentNumber = stayApartmentNumber;
    }

    public String getResidenceApartmentNumber() {
        return residenceApartmentNumber;
    }

    public void setResidenceApartmentNumber(String residenceApartmentNumber) {
        this.residenceApartmentNumber = residenceApartmentNumber;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public LocalDate getDatePositiveFrom() {
        return datePositiveFrom;
    }

    public void setDatePositiveFrom(LocalDate datePositiveFrom) {
        this.datePositiveFrom = datePositiveFrom;
    }

    public LocalDate getDateInformationFrom() {
        return dateInformationFrom;
    }

    public void setDateInformationFrom(LocalDate dateInformationFrom) {
        this.dateInformationFrom = dateInformationFrom;
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
