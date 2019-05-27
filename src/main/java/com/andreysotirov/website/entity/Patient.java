package com.andreysotirov.website.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients_table")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patient_procedures")
    private String patientProcedures;

    @Column(name = "patient_direction")
    private String patientDirection;

    @Column(name = "patient_price")
    private double patientPrice;


    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateOfVisit) {
        this.date = dateOfVisit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientProcedures() {
        return patientProcedures;
    }

    public void setPatientProcedures(String patientProcedures) {
        this.patientProcedures = patientProcedures;
    }

    public String getPatientDirection() {
        return patientDirection;
    }

    public void setPatientDirection(String patientDirection) {
        this.patientDirection = patientDirection;
    }

    public double getPatientPrice() {
        return patientPrice;
    }

    public void setPatientPrice(double patientPrice) {
        this.patientPrice = patientPrice;
    }

}
