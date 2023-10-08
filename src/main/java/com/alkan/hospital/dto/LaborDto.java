package com.alkan.hospital.dto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class LaborDto implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    @Size(min = 7,max = 7,message = "Hospital id must be 7 characters")
    private int hospitalId;
    @Size(min = 6,max = 6,message = "Password must be 6 characters")
    private int password;
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
        this.hospitalId = hospitalId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public List<ReportDto> getReportDtoList() {
        return reportDtoList;
    }

    public void setReportDtoList(List<ReportDto> reportDtoList) {
        this.reportDtoList = reportDtoList;
    }
}
