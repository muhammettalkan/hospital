package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.entity.Labor;
import com.alkan.hospital.exception.DigitExceptionForHospitalId;
import com.alkan.hospital.exception.LoginException;
import com.alkan.hospital.repository.LaborRepository;
import com.alkan.hospital.service.LaborService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (Integer.toString(dto.getHospitalId()).length() != 7){
            throw new DigitExceptionForHospitalId("Hospital id must be 7 characters");
        }
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
    @Override
    public List<LaborDto> findAll(){
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public LaborDto login(LoginRequest request){
        Labor labor = findByHospitalId(request.username);
        if(String.valueOf(labor.getPassword()) != request.password){
            throw new LoginException("Username or password is incorrect");
        }
        return toDto(labor);
    }
    @Override
    public Labor findByHospitalId(String hospitalId) {
        return repository.findByHospitalId(hospitalId);
    }


}
