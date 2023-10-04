package com.alkan.hospital.response;

public class BaseResponse {

    public int code;
    public String message;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
