package com.alkan.hospital.response;

import com.alkan.hospital.dto.LaborDto;

public class LaborResponse extends BaseResponse{

    public LaborDto laborDto;

    public LaborResponse(int code, String message, LaborDto laborDto) {
        super(code, message);
        this.laborDto = laborDto;
    }
}
