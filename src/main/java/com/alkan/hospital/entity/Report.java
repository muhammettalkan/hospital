package com.alkan.hospital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileNumber;
    private String diagnosis;
    private String diagnosisDetail;
    private LocalDateTime date;
    private String reportPhotoUrl;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Labor labor;

    public Report() {
    }

    public Report(int id, String fileNumber, String diagnosis, String diagnosisDetail, LocalDateTime date, String reportPhotoUrl, Patient patient, Labor labor) {
        this.id = id;
        this.fileNumber = fileNumber;
        this.diagnosis = diagnosis;
        this.diagnosisDetail = diagnosisDetail;
        this.date = date;
        this.reportPhotoUrl = reportPhotoUrl;
        this.patient = patient;
        this.labor = labor;
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
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReportPhotoUrl() {
        return reportPhotoUrl;
    }

    public void setReportPhotoUrl(String reportPhotoUrl) {
        this.reportPhotoUrl = reportPhotoUrl;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Labor getLabor() {
        return labor;
    }

    public void setLabor(Labor labor) {
        this.labor = labor;
    }

}
