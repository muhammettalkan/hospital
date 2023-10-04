package com.alkan.hospital.dto;

import java.io.Serializable;
import java.util.List;

public class PatientDto implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private List<ReportDto> reportList;

    public PatientDto() {
    }

    public PatientDto(int id, String firstName, String lastName, String nationalId, List<ReportDto> reportList) {
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

    public List<ReportDto> getReportList() {
        return reportList;
    }

    public void setReportList(List<ReportDto> reportList) {
        this.reportList = reportList;
    }
}
