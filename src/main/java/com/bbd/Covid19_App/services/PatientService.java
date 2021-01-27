package com.bbd.Covid19_App.services;

import com.bbd.Covid19_App.entities.Patient;
import com.bbd.Covid19_App.dao.PatientRepository;
import com.bbd.Covid19_App.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PatientService  {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findByPatientId(Integer patientId) {
        return patientRepository.findByPatientId(patientId);
    }

    public List<Patient> findAllByCreator(User creator) {
        return patientRepository.findAllByCreator(creator);
    }
    public List<Patient> findAllByEverything(String name,
                                             String surname,
                                             String gender,
                                             LocalDate birthDateFrom,
                                             LocalDate birthDateTo,
                                             Integer ageFrom,
                                             Integer ageTo,
                                             LocalDate datePositiveFrom,
                                             LocalDate datePositiveTo,
                                             LocalDate dateInformationFrom,
                                             LocalDate dateInformationTo,
                                             String residenceStreet,
                                             String residenceCityCode,
                                             String residenceCity,
                                             String residenceDistrict,
                                             String stayStreet,
                                             String stayCityCode,
                                             String stayCity,
                                             String stayDistrict,
                                             String hospitalName,
                                             Boolean hospitalized,
                                             Boolean inQuarantine,
                                             Boolean supervision,
                                             String labName,
                                             String infectionSource,
                                             String phoneNumber,
                                             String email,
                                             String creatorLogin) {

        return patientRepository.findAllByEverything(name,
                                                     surname,
                                                     gender,
                                                     birthDateFrom,
                                                     birthDateTo,
                                                     ageFrom,
                                                     ageTo,
                                                     datePositiveFrom,
                                                     datePositiveTo,
                                                     dateInformationFrom,
                                                     dateInformationTo,
                                                     residenceStreet,
                                                     residenceCityCode,
                                                     residenceCity,
                                                     residenceDistrict,
                                                     stayStreet,
                                                     stayCityCode,
                                                     stayCity,
                                                     stayDistrict,
                                                     hospitalName,
                                                     hospitalized,
                                                     inQuarantine,
                                                     supervision,
                                                     labName,
                                                     infectionSource,
                                                     phoneNumber,
                                                     email,
                                                     creatorLogin);
    }

    public void deleteByPatientId(Integer patientId) {
        patientRepository.deleteByPatientId(patientId);
    }
}
