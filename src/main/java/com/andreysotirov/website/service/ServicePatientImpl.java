package com.andreysotirov.website.service;

import com.andreysotirov.website.dao.PatientRepo;
import com.andreysotirov.website.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServicePatientImpl implements ServicePatient {

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patientRepo.findById(id);
    }

    @Override
    public void save(Patient patient) {
        Date now = new Date();
        patient.setDate(now);
        patientRepo.save(patient);
    }

    @Override
    public void deleteById(int id) {
        patientRepo.deleteById(id);
    }

    @Override
    public Double getSum() {
        return patientRepo.getSum();
    }

    @Override
    public Double getTurnover() {
        return patientRepo.getTurnover();
    }
}
