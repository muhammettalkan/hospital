package com.alkan.hospital.response;

import com.alkan.hospital.dto.PatientDto;

public class PatientResponse extends BaseResponse{

    public PatientDto patientDto;
    public PatientResponse(int code, String message, PatientDto patientDto) {
        super(code, message);
        this.patientDto = patientDto;
    }
}
