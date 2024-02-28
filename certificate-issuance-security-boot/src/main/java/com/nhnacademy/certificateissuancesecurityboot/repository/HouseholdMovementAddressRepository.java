package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk> {
}
