package com.alkan.hospital.service;

import com.alkan.hospital.dto.ReportDto;
import com.alkan.hospital.dto.request.UpdateRequest;
import com.alkan.hospital.entity.Report;

import java.util.List;

public interface ReportService {
    Report findById(int id);
    Report toEntity(ReportDto dto);
    ReportDto toDto(Report report);
    ReportDto create(ReportDto dto);
    List<ReportDto> findByPatient(String firstName, String lastName);
    List<ReportDto> findByPatientNationalId(String nationalId);
    List<ReportDto> findByLabor(String firstName, String lastName);
    List<ReportDto> findAllByOrderByDateAsc(String orderBy);
    ReportDto update(int id, UpdateRequest request);
    List<ReportDto> findAll();
    String delete(int id);

    String randomPhotoUrl();
}
