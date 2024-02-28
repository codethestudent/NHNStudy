package com.example.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuance.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
}
