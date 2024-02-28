package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
    List<HouseholdCompositionResident> findByPk_HouseholdSerialNumber(int householdSerialNumber);

    HouseholdCompositionResident findByPk_ResidentSerialNumber(int residentSerialNumber);
}
