package com.bbd.Covid19_App.dao;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {


    List<Patient> findAll();

    Patient findByPatientId(Integer patientId);


    Patient save(Patient patient);

    void deleteByPatientId(Integer patientId);

    List<Patient> findAllByCreator(User creator);

    @Query("SELECT p FROM Patient p WHERE (:name = '' or p.name LIKE %:name%)"
                                  + " and (:surname = '' or p.surname LIKE %:surname%)"
                                  + " and (:gender = '' or p.gender = :gender)"
                                  + " and (:birthDateFrom is null or p.birthDate >= :birthDateFrom)"
                                  + " and (:birthDateTo is null or p.birthDate <= :birthDateTo)"
                                  + " and (:ageFrom is null or p.age >= :ageFrom)"
                                  + " and (:ageTo is null or p.age <= :ageTo)"
                                  + " and (:datePositiveFrom is null or p.datePositive >= :datePositiveFrom)"
                                  + " and (:datePositiveTo is null or p.datePositive <= :datePositiveTo)"
                                  + " and (:dateInformationFrom is null or p.dateInformation >= :dateInformationFrom)"
                                  + " and (:dateInformationTo is null or p.dateInformation <= :dateInformationTo)"
                                  + " and (:infectionSource = '' or p.infectionSource LIKE %:infectionSource%)"
                                  + " and (:residenceStreet = '' or p.residenceStreet LIKE %:residenceStreet%)"
                                  + " and (:residenceCityCode = '' or p.residenceCityCode LIKE %:residenceCityCode%)"
                                  + " and (:residenceCity = '' or p.residenceCity LIKE %:residenceCity%)"
                                  + " and (:residenceDistrict = '' or p.residenceDistrict LIKE %:residenceDistrict%)"
                                  + " and (:stayStreet = '' or p.stayStreet LIKE %:stayStreet%)"
                                  + " and (:stayCityCode = '' or p.stayCityCode LIKE %:stayCityCode%)"
                                  + " and (:stayCity = '' or p.stayCity LIKE %:stayCity%)"
                                  + " and (:stayDistrict = '' or p.stayDistrict LIKE %:stayDistrict%)"
                                  + " and (:hospitalName = '' or p.hospitalName LIKE %:hospitalName%)"
                                  + " and (:hospitalized is null or p.hospitalized = :hospitalized)"
                                  + " and (:inQuarantine is null or p.inQuarantine = :inQuarantine)"
                                  + " and (:supervision is null or p.supervision = :supervision)"
                                  + " and (:labName = '' or p.labName LIKE %:labName%)"
                                  + " and (:phoneNumber = '' or p.phoneNumber LIKE %:phoneNumber%)"
                                  + " and (:email = '' or p.email LIKE %:email%)"
                                  + " and (:creatorLogin = '' or p.creator.login LIKE %:creatorLogin%)")
    List<Patient> findAllByEverything(@Param("name") String name,
                                      @Param("surname") String surname,
                                      @Param("gender") String gender,
                                      @Param("birthDateFrom") LocalDate birthDateFrom,
                                      @Param("birthDateTo") LocalDate birthDateTo,
                                      @Param("ageFrom") Integer ageFrom,
                                      @Param("ageTo") Integer ageTo,
                                      @Param("datePositiveFrom") LocalDate datePositiveFrom,
                                      @Param("datePositiveTo") LocalDate datePositiveTo,
                                      @Param("dateInformationFrom") LocalDate dateInformationFrom,
                                      @Param("dateInformationTo") LocalDate dateInformationTo,
                                      @Param("residenceStreet") String residenceStreet,
                                      @Param("residenceCityCode") String residenceCityCode,
                                      @Param("residenceCity") String residenceCity,
                                      @Param("residenceDistrict") String residenceDistrict,
                                      @Param("stayStreet") String stayStreet,
                                      @Param("stayCityCode") String stayCityCode,
                                      @Param("stayCity") String stayCity,
                                      @Param("stayDistrict") String stayDistrict,
                                      @Param("hospitalName") String hospitalName,
                                      @Param("hospitalized") Boolean hospitalized,
                                      @Param("inQuarantine") Boolean inQuarantine,
                                      @Param("supervision") Boolean supervision,
                                      @Param("labName") String labName,
                                      @Param("infectionSource") String infectionSource,
                                      @Param("phoneNumber") String phoneNumber,
                                      @Param("email") String email,
                                      @Param("creatorLogin") String creatorLogin);

}
