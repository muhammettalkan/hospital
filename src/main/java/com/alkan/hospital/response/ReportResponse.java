package com.alkan.hospital.response;

import com.alkan.hospital.dto.ReportDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ReportResponse extends BaseResponse{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ReportDto data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ReportDto> dataList;
    public ReportResponse(int code, String message, ReportDto data) {
        super(code, message);
        this.data = data;
    }
    public ReportResponse(int code, String message, List<ReportDto> dataList) {
        super(code, message);
        this.dataList = dataList;
    }
}
