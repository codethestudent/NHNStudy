package com.nhnacademy.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuancesecurityboot.entity.Household;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.repository.HouseholdRepository;
import com.nhnacademy.certificateissuancesecurityboot.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public Household getHousehold(int householdSerialNumber) {
        Optional<Household> household = householdRepository.findById(householdSerialNumber);
        if (household.isEmpty()) {
            throw new EntityNotFoundException(householdSerialNumber + " not found");
        }
        return household.get();
    }
}
