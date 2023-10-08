package com.alkan.hospital.controller;

import com.alkan.hospital.dto.PatientDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.response.PatientResponse;
import com.alkan.hospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<PatientResponse> create(@RequestBody PatientDto patientDto){
        return ResponseEntity.ok(new PatientResponse(200, "Patient created successfully", service.create(patientDto)));
    }
    @PostMapping("/login")
    public ResponseEntity<PatientResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(new PatientResponse(200, "Patient logged in successfully", service.login(request)));
    }

}
