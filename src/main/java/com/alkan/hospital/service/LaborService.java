package com.alkan.hospital.service;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.entity.Labor;

public interface LaborService {

    Labor findById(int id);
    LaborDto create(LaborDto dto);
    Labor toEntity(LaborDto dto);
    LaborDto toDto(Labor labor);

}
