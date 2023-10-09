package com.alkan.hospital.controller;

import com.alkan.hospital.dto.ReportDto;
import com.alkan.hospital.dto.request.UpdateRequest;
import com.alkan.hospital.response.ReportResponse;
import com.alkan.hospital.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ReportResponse> create(@RequestBody ReportDto dto){
        return ResponseEntity.ok(new ReportResponse(200, "Report created successfully", service.create(dto)));
    }
    @GetMapping("/find-by-patient-name/{firstName}/{lastName}")
    public ResponseEntity<ReportResponse> findByPatient(@PathVariable String firstName, @PathVariable String lastName){
        return ResponseEntity.ok(new ReportResponse(200, "Reports found successfully", service.findByPatient(firstName, lastName)));
    }
    @GetMapping("/find-patient")
    public ResponseEntity<ReportResponse> findByPatientNationalId(@RequestParam String nationalId){
        return ResponseEntity.ok(new ReportResponse(200, "Reports found successfully", service.findByPatientNationalId(nationalId)));
    }
    @GetMapping("/find-by-labor-name/{firstName}/{lastName}")
    public ResponseEntity<ReportResponse> findByLabor(@PathVariable String firstName, @PathVariable String lastName){
        return ResponseEntity.ok(new ReportResponse(200, "Reports found successfully", service.findByLabor(firstName, lastName)));
    }
    @GetMapping("/find-all-by-order")
    public ResponseEntity<ReportResponse> findAllByOrderByDateAsc(@RequestParam String orderBy){
        return ResponseEntity.ok(new ReportResponse(200, "Reports found successfully", service.findAllByOrderByDateAsc(orderBy)));
    }
    @PutMapping("/update")
    public ResponseEntity<ReportResponse> update(@RequestParam int id, @RequestBody UpdateRequest request){
        return ResponseEntity.ok(new ReportResponse(200, "Report updated successfully", service.update(id, request)));
    }
    @GetMapping()
    public ResponseEntity<ReportResponse> findAll(){
        return ResponseEntity.ok(new ReportResponse(200, "Reports found successfully", service.findAll()));
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam int id){
        service.delete(id);
        return "Report deleted successfully";
    }
}
