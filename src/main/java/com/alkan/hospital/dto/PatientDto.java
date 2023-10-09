package com.alkan.hospital.dto;

import com.alkan.hospital.exception.NationalIdException;

import java.io.Serializable;
import java.util.List;

public class PatientDto implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String password;
    private List<ReportDto> reportList;

    public PatientDto() {
    }

    public PatientDto(int id, String firstName, String lastName, String nationalId, List<ReportDto> reportList, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        if (nationalId.length() != 11) throw new NationalIdException("National Id must be 11 characters");
        this.nationalId = nationalId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReportDto> getReportList() {
        return reportList;
    }

    public void setReportList(List<ReportDto> reportList) {
        this.reportList = reportList;
    }
}
