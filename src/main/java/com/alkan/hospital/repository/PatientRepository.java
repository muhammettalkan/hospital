package com.alkan.hospital.repository;

import com.alkan.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByNationalId(String nationalId);
}
