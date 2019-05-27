package com.andreysotirov.website.service;

import com.andreysotirov.website.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface ServicePatient {

    List<Patient> findAll();

    Optional<Patient> findById(int id);

    void save(Patient patient);

    void deleteById(int id);

    Double getSum();

    Double getTurnover();

}
