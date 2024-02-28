package com.nhnacademy.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuancesecurityboot.domain.FamilyRelationshipDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.FamilyRelationship;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.repository.FamilyRelationshipRepository;
import com.nhnacademy.certificateissuancesecurityboot.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public FamilyRelationship registerFamilyRelationship(int baseSerialNumber, FamilyRelationshipDto familyRelationshipDto) {
        Optional<Resident> baseResidentOpt = residentRepository.findById(baseSerialNumber);
        Optional<Resident> familyResidentOpt = residentRepository.findById(familyRelationshipDto.getFamilySerialNumber());

        if (!baseResidentOpt.isPresent() || !familyResidentOpt.isPresent()) {
            throw new EntityNotFoundException("Resident not found");
        }

        FamilyRelationship familyRelationship = new FamilyRelationship();
        familyRelationship.setPk(new FamilyRelationship.Pk(familyRelationshipDto.getFamilySerialNumber(), baseSerialNumber));
        familyRelationship.setFamilyResident(familyResidentOpt.get());
        familyRelationship.setBaseResident(baseResidentOpt.get());
        familyRelationship.setFamilyRelationshipCode(familyRelationshipDto.getRelationShip());

        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public FamilyRelationship updateFamilyRelationship(int serialNumber,
                                                       int familySerialNumber,
                                                       FamilyRelationshipDto familyRelationshipDto) {
        Optional<FamilyRelationship> familyRelationshipOpt = familyRelationshipRepository.findById(new FamilyRelationship.Pk(familySerialNumber, serialNumber));

        if (familyRelationshipOpt.isPresent()) {
            FamilyRelationship familyRelationship = familyRelationshipOpt.get();
            familyRelationship.setFamilyRelationshipCode(familyRelationshipDto.getRelationShip());
            return familyRelationshipRepository.save(familyRelationship);
        } else {
            throw new EntityNotFoundException("FamilyRelationshipEntity not found");
        }
    }

    @Override
    public void deleteFamilyRelationship(int baseSerialNumber, int familySerialNumber) {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(familySerialNumber, baseSerialNumber);
        if (!familyRelationshipRepository.existsById(pk)) {
            throw new EntityNotFoundException("FamilyRelationshipEntity not found for id: " + pk);
        }
        familyRelationshipRepository.deleteById(pk);
    }
}
