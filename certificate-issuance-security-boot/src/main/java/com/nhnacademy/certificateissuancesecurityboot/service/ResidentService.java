package com.nhnacademy.certificateissuancesecurityboot.service;


import com.nhnacademy.certificateissuancesecurityboot.domain.ResidentRegisterDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;

public interface ResidentService {
    Resident registerResident(ResidentRegisterDto residentRegisterDto);

    Resident updateResident(int serialNumber, ResidentRegisterDto residentRegisterDto);

    Resident getResident(String id);

    Resident getResidentByEmail(String email);
}
