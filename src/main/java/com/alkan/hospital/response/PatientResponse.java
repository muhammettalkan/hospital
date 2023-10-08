package com.alkan.hospital.response;

import com.alkan.hospital.dto.PatientDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class PatientResponse extends BaseResponse{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PatientDto data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<PatientDto> dataList;
    public PatientResponse(int code, String message, PatientDto data) {
        super(code, message);
        this.data = data;
    }
    public PatientResponse(int code, String message, List<PatientDto> dataList) {
        super(code, message);
        this.dataList = dataList;
    }
}
