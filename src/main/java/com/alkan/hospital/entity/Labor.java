package com.alkan.hospital.entity;

import com.alkan.hospital.exception.DigitExceptionForHospitalId;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Labor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private int hospitalId;
    private String password;
    @OneToMany(mappedBy = "labor")
    private List<Report> reportList;

    public Labor() {
    }

    public Labor(int id, String firstName, String lastName, int hospitalId, List<Report> reportList, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalId = hospitalId;
        this.reportList = reportList;
        this.password = password;
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

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        if (String.valueOf(hospitalId).length() != 7) throw new DigitExceptionForHospitalId("Hospital Id must be 7 characters");
        this.hospitalId = hospitalId;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

