package com.alkan.hospital.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReportDto implements Serializable {
    private int id;
    private String fileNumber;
    private String diagnosis;
    private String diagnosisDetail;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;
    private String reportPhotoUrl;
    private String patientFullName;
    private String laborFullName;
    private int patientId;
    private int laborId;

    public ReportDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosisDetail() {
        return diagnosisDetail;
    }

    public void setDiagnosisDetail(String diagnosisDetail) {
        this.diagnosisDetail = diagnosisDetail;
    }

    public LocalDateTime getDate() {
        return creationDate;
    }

    public void setDate(LocalDateTime date) {
        this.creationDate = date;
    }

    public String getReportPhotoUrl() {
        return reportPhotoUrl;
    }

    public void setReportPhotoUrl(String reportPhotoUrl) {
        this.reportPhotoUrl = reportPhotoUrl;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getLaborId() {
        return laborId;
    }

    public void setLaborId(int laborId) {
        this.laborId = laborId;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public String getLaborFullName() {
        return laborFullName;
    }

    public void setLaborFullName(String laborFullName) {
        this.laborFullName = laborFullName;
    }
}
