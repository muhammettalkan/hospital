package com.alkan.hospital.service;

import com.alkan.hospital.dto.PatientDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient findById(int id);
    Patient toEntity(PatientDto dto);
    PatientDto toDto(Patient entity);
    PatientDto create(PatientDto dto);
    PatientDto login(LoginRequest request);
    PatientDto findByNationalId(String nationalId);
    List<PatientDto> findAll();
}
