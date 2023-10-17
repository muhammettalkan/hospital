package com.alkan.hospital.controller;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.dto.request.LoginRequest;
import com.alkan.hospital.response.LaborResponse;
import com.alkan.hospital.service.LaborService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/labors")
public class LaborController {

    private final LaborService service;

    public LaborController(LaborService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<LaborResponse> findAll(){
        return ResponseEntity.ok(new LaborResponse(200, "Labors found successfully", service.findAll()));
    }
    @PostMapping("/create")
    public ResponseEntity<LaborResponse> create(@RequestBody LaborDto dto){
        return ResponseEntity.ok(new LaborResponse(200, "Labor created successfully", service.create(dto)));
    }
    @PostMapping("/login")
    public ResponseEntity<LaborResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(new LaborResponse(200, "Labor logged in successfully", service.login(request)));
    }
    @GetMapping("/hospital-id")
    public ResponseEntity<LaborResponse> findById(@RequestParam String id){
        return ResponseEntity.ok(new LaborResponse(200, "Labor found successfully", service.findByHospitalId(id)));
    }
    @PutMapping("{id}/update")
    public ResponseEntity<LaborResponse> update(@PathVariable int id, @RequestBody LaborDto dto){
        return ResponseEntity.ok(new LaborResponse(200, "Labor updated successfully", service.update(id, dto)));
    }
    @GetMapping("/find-by-id")
    public ResponseEntity<LaborResponse> findLaborById(@RequestParam String id){
        return ResponseEntity.ok(new LaborResponse(200, "Labor found successfully", service.findLaborById(id)));
    }

}
