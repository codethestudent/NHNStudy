package com.nhnacademy.certificateissuancesecurityboot.service;


import com.nhnacademy.certificateissuancesecurityboot.domain.BirthReportDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.BirthDeathReportResident;

public interface BirthDeathReportResidentService {
    BirthDeathReportResident registerResidentBirth(int serialNumber, BirthReportDto birthReportDto);


    BirthDeathReportResident updateResidentBirth(int serialNumber, int targetSerialNumber, BirthReportDto birthReportDto);


    void deleteResidentBirth(int serialNumber, int targetSerialNumber);
}
