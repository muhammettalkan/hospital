package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.PatientDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.entity.Patient;
import com.alkan.hospital.exception.LoginException;
import com.alkan.hospital.exception.NationalIdException;
import com.alkan.hospital.repository.PatientRepository;
import com.alkan.hospital.service.PatientService;
import com.alkan.hospital.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final ReportService reportService;
    public PatientServiceImpl(PatientRepository repository, ReportService reportService) {
        this.repository = repository;
        this.reportService = reportService;
    }
    public Patient findById(int id){
        return repository.findById(id).get();
    }
    public Patient toEntity(PatientDto dto){
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setNationalId(dto.getNationalId());
        patient.setPassword(dto.getPassword());
        if (dto.getReportList() != null) {
            patient.setReportList(dto.getReportList().stream().map(reportService::toEntity).toList());
        }
        return patient;
    }
    public PatientDto toDto(Patient entity){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(entity.getId());
        patientDto.setFirstName(entity.getFirstName());
        patientDto.setLastName(entity.getLastName());
        patientDto.setNationalId(entity.getNationalId());
        patientDto.setPassword(entity.getPassword());
        if (entity.getReportList() != null) {
            patientDto.setReportList(entity.getReportList().stream().map(reportService::toDto).toList());
        }
        return patientDto;
    }
    public PatientDto create(PatientDto dto){
        Patient patient = toEntity(dto);
        repository.save(patient);
        return toDto(patient);
    }
    @Override
    public PatientDto login(LoginRequest request){
        PatientDto patientDto = findByNationalId(request.username);
        if(patientDto.getPassword() != request.password){
            throw new LoginException("Username or password is incorrect");
        }
        return patientDto;
    }
    @Override
    public PatientDto findByNationalId(String nationalId) {
        if (nationalId.length() != 11) throw new NationalIdException("National Id must be 11 characters");
        Patient patient = repository.findByNationalId(nationalId);
        return toDto(patient);
    }
    @Override
    public List<PatientDto> findAll(){
        return repository.findAll().stream().map(this::toDto).toList();
    }

}
