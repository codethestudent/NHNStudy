package com.nhnacademy.certificateissuancesecurityboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HouseholdDto {
    private int residentSerialNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime householdCompositionDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;
}
