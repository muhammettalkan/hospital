package com.alkan.hospital.dto;

import com.alkan.hospital.exception.DigitExceptionForHospitalId;

import java.io.Serializable;
import java.util.List;

public class LaborDto implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private int hospitalId;
    private String password;
    private List<ReportDto> reportDtoList;

    public LaborDto() {
    }

    public LaborDto(int id, String firstName, String lastName, int hospitalId, List<ReportDto> reportDtoList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalId = hospitalId;
        this.reportDtoList = reportDtoList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReportDto> getReportDtoList() {
        return reportDtoList;
    }

    public void setReportDtoList(List<ReportDto> reportDtoList) {
        this.reportDtoList = reportDtoList;
    }
}
