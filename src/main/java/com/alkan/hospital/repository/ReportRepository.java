package com.alkan.hospital.repository;

import com.alkan.hospital.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

    List<Report> findByPatientFirstNameAndPatientLastName(String firstName, String lastName);
    List<Report> findReportByPatientNationalId(String nationalId);
    List<Report> findReportByLaborFirstNameAndLaborLastName(String firstName, String lastName);
    @Query("SELECT r FROM Report r ORDER BY CASE WHEN :orderBy = 'asc' THEN r.date END ASC, CASE WHEN :orderBy = 'desc' THEN r.date END DESC")
    List<Report> findAllOrderedByCreationTime(@Param("orderBy") String orderBy);
}
