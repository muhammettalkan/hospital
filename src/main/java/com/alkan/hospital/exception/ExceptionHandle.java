package com.alkan.hospital.exception;

import com.alkan.hospital.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle{

    @ExceptionHandler(DigitExceptionForHospitalId.class)
    public ResponseEntity<Object> parseNumberResponse(){
        BaseResponse response = new BaseResponse(1001, "Please enter your 7-digit hospital id");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<Object> loginResponse(){
        BaseResponse response = new BaseResponse(1002, "Username or password is incorrect");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.OK);
        return entity;
    }

}
