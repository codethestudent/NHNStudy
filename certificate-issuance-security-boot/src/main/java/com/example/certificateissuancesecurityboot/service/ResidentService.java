package com.example.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuance.domain.ResidentRegisterDto;
import com.nhnacademy.certificateissuance.entity.Resident;

public interface ResidentService {
    Resident registerResident(ResidentRegisterDto residentRegisterDto);

    Resident updateResident(int serialNumber, ResidentRegisterDto residentRegisterDto);
}
