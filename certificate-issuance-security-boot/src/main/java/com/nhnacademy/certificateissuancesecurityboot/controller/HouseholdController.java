package com.nhnacademy.certificateissuancesecurityboot.controller;

import com.nhnacademy.certificateissuancesecurityboot.domain.HouseholdDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.Household;
import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.certificateissuancesecurityboot.repository.HouseholdRepository;
import com.nhnacademy.certificateissuancesecurityboot.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/household")
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdRepository householdRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;
    private final ResidentRepository residentRepository;

    @PostMapping
    public Household registerHousehold(@RequestBody HouseholdDto householdDto) {
        Resident resident = residentRepository.findByResidentSerialNumber(householdDto.getResidentSerialNumber());
        Household household = new Household(
                resident,
                householdDto.getHouseholdCompositionDate(),
                householdDto.getHouseholdCompositionReasonCode(),
                householdDto.getCurrentHouseMovementAddress()
        );

        return householdRepository.save(household);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHousehold(@PathVariable int id) {
        Optional<Household> household = householdRepository.findById(id);
        if (household.isEmpty()) {
            return ResponseEntity.badRequest().body("can't find household id : " + id);
        }
        householdRepository.delete(household.get());
        return ResponseEntity.ok().body("ok");
    }



}
