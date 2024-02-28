package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {
}
