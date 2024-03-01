package com.nhnacademy.certificateissuancesecurityboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HouseholdCompositionResidentDTO {

    private int householdSerialNumber;
    private int residentSerialNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "Asia/Seoul")
    private LocalDateTime reportDate;
    private String householdRelationshipCode;
    private String householdCompositionChangeReasonCode;
}
