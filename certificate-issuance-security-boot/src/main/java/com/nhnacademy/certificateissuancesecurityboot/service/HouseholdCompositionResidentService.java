package com.nhnacademy.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import com.nhnacademy.certificateissuancesecurityboot.repository.HouseholdCompositionResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HouseholdCompositionResidentService {

    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    public Page<HouseholdCompositionResident> getHouseholdCompositionResidents(int householdSerialNumber, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return householdCompositionResidentRepository.findByPk_HouseholdSerialNumber(householdSerialNumber, pageable);
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
