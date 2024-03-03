package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
    Page<HouseholdCompositionResident> findByPk_HouseholdSerialNumber(int householdSerialNumber, Pageable pageable);

    HouseholdCompositionResident findByPk_ResidentSerialNumber(int residentSerialNumber);
}
