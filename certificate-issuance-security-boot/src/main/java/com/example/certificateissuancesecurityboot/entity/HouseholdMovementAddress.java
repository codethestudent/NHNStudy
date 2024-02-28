package com.example.certificateissuancesecurityboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;
    @ManyToOne
    @MapsId("householdSerialNumber")
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @Column(name = "house_movement_address")
    private String houseMovementAddress;

    @Column(name = "last_address_yn")
    private String lastAddressYn;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private int householdSerialNumber;
        @Column(name = "house_movement_report_date")
        private LocalDateTime houseMovementReportDate;
    }
}
