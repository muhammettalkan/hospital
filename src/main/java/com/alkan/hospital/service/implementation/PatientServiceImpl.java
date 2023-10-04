package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.PatientDto;
import com.alkan.hospital.entity.Patient;
import com.alkan.hospital.repository.PatientRepository;
import com.alkan.hospital.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
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
        return patient;
    }
    public PatientDto toDto(Patient entity){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(entity.getId());
        patientDto.setFirstName(entity.getFirstName());
        patientDto.setLastName(entity.getLastName());
        patientDto.setNationalId(entity.getNationalId());
        return patientDto;
    }
    public PatientDto create(PatientDto dto){
        Patient patient = toEntity(dto);
        repository.save(patient);
        return toDto(patient);
    }

}
