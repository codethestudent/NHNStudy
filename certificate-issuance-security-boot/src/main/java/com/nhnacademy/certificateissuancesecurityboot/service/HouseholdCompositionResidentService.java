package com.nhnacademy.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import com.nhnacademy.certificateissuancesecurityboot.repository.HouseholdCompositionResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HouseholdCompositionResidentService {

    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public List<HouseholdCompositionResident> getHouseholdCompositionResidents(int householdSerialNumber) {
        List<HouseholdCompositionResident> householdCompositionResidents = householdCompositionResidentRepository.findByPk_HouseholdSerialNumber(householdSerialNumber);
        if (householdCompositionResidents.isEmpty()) {
            throw new EntityNotFoundException("household serial number: " + householdSerialNumber + " not found");
        } else {
            return householdCompositionResidents;
        }
    }

    public HouseholdCompositionResident getHouseholdCompositionResident(int residentSerialNumber) {
        HouseholdCompositionResident householdCompositionResident =
                householdCompositionResidentRepository.findByPk_ResidentSerialNumber(residentSerialNumber);

        if (Objects.isNull(householdCompositionResident)) {
            throw new EntityNotFoundException("residentSerialNumber : " + residentSerialNumber + " not found");
        }

        return householdCompositionResident;
    }

}
