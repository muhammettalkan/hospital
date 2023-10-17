package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.ReportDto;
import com.alkan.hospital.dto.request.UpdateRequest;
import com.alkan.hospital.entity.Report;
import com.alkan.hospital.repository.ReportRepository;
import com.alkan.hospital.service.LaborService;
import com.alkan.hospital.service.PatientService;
import com.alkan.hospital.service.ReportService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final LaborService laborService;
    private final PatientService patientService;
    public ReportServiceImpl(ReportRepository reportRepository, @Lazy LaborService laborService,@Lazy PatientService patientService) {
        this.reportRepository = reportRepository;
        this.laborService = laborService;
        this.patientService = patientService;
    }
    public Report findById(int id) {
        return reportRepository.findById(id).get();
    }
    @Override
    public ReportDto findReportById(String id){
        Report report = findById(Integer.parseInt(id));
        return toDto(report);
    }
    public Report toEntity(ReportDto dto){
        Report report = new Report();
        report.setId(dto.getId());
        report.setFileNumber(dto.getFileNumber());
        report.setDiagnosis(dto.getDiagnosis());
        report.setDiagnosisDetail(dto.getDiagnosisDetail());
        report.setDate(dto.getDate());
        report.setReportPhotoUrl(dto.getReportPhotoUrl());
        report.setPatient(patientService.findById(dto.getPatientId()));
        report.setLabor(laborService.findById(dto.getLaborId()));
        return report;
    }
    public ReportDto toDto(Report report){
        ReportDto dto = new ReportDto();
        dto.setId(report.getId());
        dto.setFileNumber(report.getFileNumber());
        dto.setDiagnosis(report.getDiagnosis());
        dto.setDiagnosisDetail(report.getDiagnosisDetail());
        dto.setDate(report.getDate());
        dto.setReportPhotoUrl(report.getReportPhotoUrl());
        dto.setPatientId(report.getPatient().getId());
        dto.setLaborId(report.getLabor().getId());
        return dto;
    }
    public ReportDto create(ReportDto dto){
        Report report = toEntity(dto);
        report.setDate(LocalDateTime.now());
        reportRepository.save(report);
        return toDto(report);
    }
    public List<ReportDto> findByPatient(String firstName, String lastName){
        if (reportRepository.findByPatientFirstNameAndPatientLastName(firstName, lastName).isEmpty()){
            throw new NoSuchElementException("There's no report with patient name: " + firstName + " " + lastName);
        }
        return reportRepository.findByPatientFirstNameAndPatientLastName(firstName, lastName)
                .stream()
                .map(this::toDto)
                .toList();
    }
    public List<ReportDto> findByPatientNationalId(String nationalId){
        if (reportRepository.findReportByPatientNationalId(nationalId).isEmpty()){
            throw new NoSuchElementException("There's no report with patient national id: " + nationalId);
        }
        return reportRepository.findReportByPatientNationalId(nationalId)
                .stream()
                .map(this::toDto)
                .toList();
    }
    public List<ReportDto> findByLabor(String firstName, String lastName){
        if (reportRepository.findReportByLaborFirstNameAndLaborLastName(firstName, lastName).isEmpty()){
            throw new NoSuchElementException("There's no report with labor name: " + firstName + " " + lastName);
        }
        return reportRepository.findReportByLaborFirstNameAndLaborLastName(firstName, lastName)
                .stream()
                .map(this::toDto)
                .toList();
    }
    public List<ReportDto> findAllByOrderByDateAsc(String orderBy){
        if (reportRepository.findAll().isEmpty()){
            throw new NullPointerException("There's no report");
        }
        return reportRepository.findAllOrderedByCreationTime(orderBy)
                .stream()
                .map(this::toDto)
                .toList();
    }
    public ReportDto update(int id, UpdateRequest request){
        if (!reportRepository.existsById(id)){
            throw new NoSuchElementException("There's no report with id: " + id + " to update");
        }
        Report oldReport = reportRepository.findById(id).get();
        oldReport.setDiagnosis(request.diagnosis);
        oldReport.setDiagnosisDetail(request.diagnosisDetail);
        oldReport.setReportPhotoUrl(request.reportPhotoUrl);
        reportRepository.save(oldReport);
        return toDto(oldReport);
    }
    public List<ReportDto> findAll(){
        if (reportRepository.findAll().isEmpty()){
            throw new NullPointerException("There's no report");
        }
        return reportRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }
    public String delete(int id){
        if (!reportRepository.existsById(id)){
            return "There's no such report with id: " + id + " to delete";
        }
        reportRepository.deleteById(id);
        return "Report deleted successfully";
    }
    @Override
    public String randomPhotoUrl(){
        return "https://picsum.photos/200/300";
    }

}
