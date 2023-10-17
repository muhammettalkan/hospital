package com.alkan.hospital.controller;

import com.alkan.hospital.dto.PatientDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.response.PatientResponse;
import com.alkan.hospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<PatientResponse> findAll(){
        return ResponseEntity.ok(new PatientResponse(200, "Patient found successfully", service.findAll()));
    }
    @PostMapping("/create")
    public ResponseEntity<PatientResponse> create(@RequestBody PatientDto patientDto){
        return ResponseEntity.ok(new PatientResponse(200, "Patient created successfully", service.create(patientDto)));
    }
    @PostMapping("/login")
    public ResponseEntity<PatientResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(new PatientResponse(200, "Patient logged in successfully", service.login(request)));
    }
    @GetMapping("/national-id")
    public ResponseEntity<PatientResponse> findByNationalId(@RequestParam String nationalId){
        return ResponseEntity.ok(new PatientResponse(200, "Patient found successfully", service.findByNationalId(nationalId)));
    }
    @PutMapping("{id}/update")
    public ResponseEntity<PatientResponse> update(@PathVariable int id, @RequestBody PatientDto patientDto){
        return ResponseEntity.ok(new PatientResponse(200, "Patient updated successfully", service.update(id, patientDto)));
    }
    @GetMapping("/find-by-id")
    public ResponseEntity<PatientResponse> findPatientById(@RequestParam String id){
        return ResponseEntity.ok(new PatientResponse(200, "Patient found successfully", service.findPatientById(id)));
    }

}
