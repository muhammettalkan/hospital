package com.alkan.hospital.service;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.entity.Labor;

import java.util.List;

public interface LaborService {

    Labor findById(int id);
    LaborDto create(LaborDto dto);
    Labor toEntity(LaborDto dto);
    LaborDto toDto(Labor labor);

    List<LaborDto> findAll();

    LaborDto login(LoginRequest request);

    Labor findByHospitalId(String hospitalId);
}
