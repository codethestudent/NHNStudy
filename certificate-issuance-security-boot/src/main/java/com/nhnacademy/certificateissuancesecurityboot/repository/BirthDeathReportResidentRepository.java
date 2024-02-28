package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.BirthDeathReportResident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
    List<BirthDeathReportResident> findAllByBirthDeathReportDate(LocalDate date);
}
