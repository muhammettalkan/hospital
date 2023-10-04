package com.alkan.hospital.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    @OneToMany(mappedBy = "patient")
    private List<Report> reportList;

    public Patient() {
    }
    public Patient(int id, String firstName, String lastName, String nationalId, List<Report> reportList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.reportList = reportList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }
}
