package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.entity.Labor;
import com.alkan.hospital.repository.LaborRepository;
import com.alkan.hospital.service.LaborService;
import org.springframework.stereotype.Service;

@Service
public class LaborServiceImpl implements LaborService {

    private final LaborRepository repository;

    public LaborServiceImpl(LaborRepository repository) {
        this.repository = repository;
    }
    public Labor findById(int id){
        return repository.findById(id).get();
    }
    public Labor toEntity(LaborDto dto){
        Labor labor = new Labor();
        labor.setId(dto.getId());
        labor.setFirstName(dto.getFirstName());
        labor.setLastName(dto.getLastName());
        labor.setHospitalId(dto.getHospitalId());
        return labor;
    }
    public LaborDto toDto(Labor labor){
        LaborDto laborDto = new LaborDto();
        laborDto.setId(labor.getId());
        laborDto.setFirstName(labor.getFirstName());
        laborDto.setLastName(labor.getLastName());
        laborDto.setHospitalId(labor.getHospitalId());
        return laborDto;
    }

    public LaborDto create(LaborDto dto) {
        Labor labor = toEntity(dto);
        repository.save(labor);
        return toDto(labor);
    }

}
