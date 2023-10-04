package com.alkan.hospital.controller;

import com.alkan.hospital.dto.LaborDto;
import com.alkan.hospital.response.LaborResponse;
import com.alkan.hospital.service.LaborService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labor")
public class LaborController {

    private final LaborService service;

    public LaborController(LaborService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<LaborResponse> create(@RequestBody LaborDto dto){
        return ResponseEntity.ok(new LaborResponse(200, "Labor created successfully", service.create(dto)));
    }
}
