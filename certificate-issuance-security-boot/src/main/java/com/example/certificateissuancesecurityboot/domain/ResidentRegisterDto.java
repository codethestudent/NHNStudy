package com.example.certificateissuancesecurityboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResidentRegisterDto {
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;
}
