package com.bbd.Covid19_App.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ-]+$", message = "Pole może zawierać tylko małe, duże litery lub \"-\".")
    @Column(name = "surname")
    private String surname;

    @Pattern(regexp = "(M|K)", message = "Błędne dane.")
    @NotBlank(message = "Pole wymagane.")
    @Length(max=1, message = "Pole wymagane.")
    @Column(name = "sex")
    private String gender;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @NotNull(message = "Pole wymagane.")
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "age")
    private int age;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @NotNull(message = "Pole wymagane.")
    @Column(name = "date_positive")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePositive;

    @PastOrPresent(message = "Data może przypadać na dni minione lub obecny.")
    @NotNull(message = "Pole wymagane.")
    @Column(name = "date_information")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateInformation;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "residence_city")
    private String residenceCity;

    @NotBlank(message = "Pole wymagane.")
    @Length(min=3, message="Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "residence_district")
    private String residenceDistrict;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "stay_city")
    private String stayCity;

    @NotBlank(message = "Pole wymagane.")
    @Length(min=3, message="Pole wymagane.")
    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]+$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "stay_district")
    private String stayDistrict;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "hospitalized")
    private Boolean hospitalized;

    @Column(name = "quarantine")
    private Boolean inQuarantine;

    @Column(name = "supervision")
    private Boolean supervision;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "laboratory")
    private String labName;

    @Pattern(regexp = "^[a-zA-ZłęóąśżźćńĄĘÓŁŚŻŹĆŃ]*$", message = "Pole może zawierać tylko małe i duże litery.")
    @Column(name = "infection_source")
    private String infectionSource;

    @NotBlank(message = "Pole wymagane.")
    @Pattern(regexp = "^[0-9]{9}$", message = "Błędny numer telefonu.")
    @Column(name = "telephone_number")
    private String phoneNumber;

    @NotBlank(message = "Pole wymagane.")
    @Email(message = "Błędny adres email.")
    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
               fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;


    public Patient() {
    }

    public Patient(String name, String surname, String gender, LocalDate birthDate, int age, LocalDate datePositive, LocalDate dateInformation, String residenceCity, String residenceDistrict, String stayCity, String stayDistrict, Boolean hospitalized, String hospitalName, Boolean inQuarantine, Boolean supervision, String labName, String infectionSource, String phoneNumber, String email) {
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
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
