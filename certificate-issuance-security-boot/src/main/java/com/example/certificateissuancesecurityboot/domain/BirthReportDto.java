package com.example.certificateissuancesecurityboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BirthReportDto {
    private String birthDeathTypeCode;
    private int reportResidentSerialNumber;
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate birthDeathReportDate;
    private String birthReportQualificationCode;
    private String deathReportQualificationCode;
    private String emailAddress;
    private String phoneNumber;
}
