package com.example.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuance.domain.FamilyRelationshipDto;
import com.nhnacademy.certificateissuance.entity.FamilyRelationship;

public interface FamilyRelationshipService {
    FamilyRelationship registerFamilyRelationship(int baseSerialNumber, FamilyRelationshipDto familyRelationshipDto);

    FamilyRelationship updateFamilyRelationship(int serialNumber, int familySerialNumber, FamilyRelationshipDto familyRelationshipDto);

    void deleteFamilyRelationship(int baseSerialNumber, int familySerialNumber);
}
