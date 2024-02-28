package com.nhnacademy.certificateissuancesecurityboot.service;


import com.nhnacademy.certificateissuancesecurityboot.domain.FamilyRelationshipDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.FamilyRelationship;

public interface FamilyRelationshipService {
    FamilyRelationship registerFamilyRelationship(int baseSerialNumber, FamilyRelationshipDto familyRelationshipDto);

    FamilyRelationship updateFamilyRelationship(int serialNumber, int familySerialNumber, FamilyRelationshipDto familyRelationshipDto);

    void deleteFamilyRelationship(int baseSerialNumber, int familySerialNumber);
}
