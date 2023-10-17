package com.alkan.hospital.service.implementation;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.entity.Labor;
import com.alkan.hospital.exception.DigitExceptionForHospitalId;
import com.alkan.hospital.exception.LoginException;
import com.alkan.hospital.repository.LaborRepository;
import com.alkan.hospital.service.LaborService;
import com.alkan.hospital.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LaborServiceImpl implements LaborService {

    private final LaborRepository repository;
    private final ReportService reportService;

    public LaborServiceImpl(LaborRepository repository, ReportService reportService) {
        this.repository = repository;
        this.reportService = reportService;
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
        labor.setPassword(dto.getPassword());
        if (dto.getReportDtoList() != null) {
            labor.setReportList(dto.getReportDtoList().stream().map(reportService::toEntity).toList());
        }
        return labor;
    }
    public LaborDto toDto(Labor labor){
        LaborDto laborDto = new LaborDto();
        laborDto.setId(labor.getId());
        laborDto.setFirstName(labor.getFirstName());
        laborDto.setLastName(labor.getLastName());
        laborDto.setHospitalId(labor.getHospitalId());
        laborDto.setPassword(labor.getPassword());
        if (labor.getReportList() != null) {
            laborDto.setReportDtoList(labor.getReportList().stream().map(reportService::toDto).toList());
        }
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
    public LaborDto findLaborById(String id){
        return toDto(findById(Integer.parseInt(id)));
    }

    @Override
    public LaborDto login(LoginRequest request){
        LaborDto laborDto = findByHospitalId(request.username);
        if(laborDto.getPassword() != request.password){
            throw new LoginException("Username or password is incorrect");
        }
        return laborDto;
    }
    @Override
    public LaborDto findByHospitalId(String hospitalId) {
        Labor labor = repository.findByHospitalId(Integer.parseInt(hospitalId));
        if (labor == null){
            throw new NoSuchElementException("There's no labor with this hospital id");
        }
        return toDto(labor);
    }
    @Override
    public LaborDto update(int id, LaborDto dto){
        Labor labor = findById(id);
        labor.setFirstName(dto.getFirstName());
        labor.setLastName(dto.getLastName());
        labor.setHospitalId(dto.getHospitalId());
        labor.setPassword(dto.getPassword());
        repository.save(labor);
        return toDto(labor);
    }


}
