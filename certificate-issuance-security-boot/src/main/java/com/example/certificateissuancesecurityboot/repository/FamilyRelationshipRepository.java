package com.example.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuance.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {
}
