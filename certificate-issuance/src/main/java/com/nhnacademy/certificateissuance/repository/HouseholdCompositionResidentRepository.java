package com.nhnacademy.certificateissuance.repository;

import com.nhnacademy.certificateissuance.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
}
