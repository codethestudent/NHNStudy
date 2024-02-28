package com.example.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuance.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk> {
}
