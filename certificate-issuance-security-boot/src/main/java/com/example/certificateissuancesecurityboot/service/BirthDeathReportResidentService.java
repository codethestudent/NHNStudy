package com.example.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuance.domain.BirthReportDto;
import com.nhnacademy.certificateissuance.entity.BirthDeathReportResident;

public interface BirthDeathReportResidentService {
    BirthDeathReportResident registerResidentBirth(int serialNumber, BirthReportDto birthReportDto);


    BirthDeathReportResident updateResidentBirth(int serialNumber, int targetSerialNumber, BirthReportDto birthReportDto);


    void deleteResidentBirth(int serialNumber, int targetSerialNumber);
}
