package com.andreysotirov.website.dao;

import com.andreysotirov.website.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

    @Query("SELECT SUM(p.patientPrice) FROM Patient p")
    Double getSum();

    @Query("select sum (p.patientPrice) from Patient p group by current_date ")
    Double getTurnover();

}
