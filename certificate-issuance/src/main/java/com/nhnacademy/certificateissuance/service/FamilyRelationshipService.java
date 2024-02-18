package com.nhnacademy.certificateissuance.service;

import com.nhnacademy.certificateissuance.domain.FamilyRelationshipDto;
import com.nhnacademy.certificateissuance.entity.FamilyRelationship;
import com.nhnacademy.certificateissuance.repository.FamilyRelationshipRepository;

public interface FamilyRelationshipService {
    FamilyRelationship registerFamilyRelationship(int baseSerialNumber, FamilyRelationshipDto familyRelationshipDto);

    FamilyRelationship updateFamilyRelationship(int serialNumber, int familySerialNumber, FamilyRelationshipDto familyRelationshipDto);

    void deleteFamilyRelationship(int baseSerialNumber, int familySerialNumber);
}
