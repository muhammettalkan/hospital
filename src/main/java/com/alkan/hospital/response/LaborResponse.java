package com.alkan.hospital.response;

import com.alkan.hospital.dto.LaborDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class LaborResponse extends BaseResponse{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LaborDto laborDto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LaborDto> laborDtoList;

    public LaborResponse(int code, String message, LaborDto laborDto) {
        super(code, message);
        this.laborDto = laborDto;
    }
    public LaborResponse(int code, String message, List<LaborDto> laborDtoList) {
        super(code, message);
        this.laborDtoList = laborDtoList;
    }
}
