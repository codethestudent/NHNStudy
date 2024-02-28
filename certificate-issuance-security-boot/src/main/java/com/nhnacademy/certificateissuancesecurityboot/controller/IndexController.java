package com.nhnacademy.certificateissuancesecurityboot.controller;

import com.nhnacademy.certificateissuancesecurityboot.entity.Household;
import com.nhnacademy.certificateissuancesecurityboot.entity.HouseholdCompositionResident;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.service.HouseholdCompositionResidentService;
import com.nhnacademy.certificateissuancesecurityboot.service.HouseholdService;
import com.nhnacademy.certificateissuancesecurityboot.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/home/{id}")
@RequiredArgsConstructor
public class IndexController {

    private final HouseholdService householdService;
    private final ResidentService residentService;

    private final HouseholdCompositionResidentService householdCompositionResidentService;

    @GetMapping
    public String getResidentRegister(@PathVariable String id, Model model) {
        Resident resident = residentService.getResident(id);
        HouseholdCompositionResident householdCompositionResident =
                householdCompositionResidentService.getHouseholdCompositionResident(resident.getResidentSerialNumber());

        int householdSerialNumber = householdCompositionResident.getPk().getHouseholdSerialNumber();

        Household household = householdService.getHousehold(householdSerialNumber);

        List<HouseholdCompositionResident> householdCompositionResidents =
                householdCompositionResidentService.getHouseholdCompositionResidents(householdSerialNumber);
        model.addAttribute("household_composition_residents", householdCompositionResidents);
        return "home";
    }
}
