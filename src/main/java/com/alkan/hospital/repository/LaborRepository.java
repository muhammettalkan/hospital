package com.alkan.hospital.repository;

import com.alkan.hospital.entity.Labor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaborRepository extends JpaRepository<Labor, Integer> {
    Labor findByHospitalId(String hospitalId);
}
