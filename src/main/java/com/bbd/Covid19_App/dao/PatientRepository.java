package com.bbd.Covid19_App.dao;

import com.bbd.Covid19_App.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

//    native for sql server
//    @Query(nativeQuery = true, value = "")
//    public List<sampleInterface> displayPatients();

}
