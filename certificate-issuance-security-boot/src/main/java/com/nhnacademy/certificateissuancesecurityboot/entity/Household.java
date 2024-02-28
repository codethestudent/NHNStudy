package com.nhnacademy.certificateissuancesecurityboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {
    @Id
    @Column(name = "household_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int householdSerialNumber;

    @OneToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @Column(name = "household_composition_date")
    private LocalDateTime householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    public Household(Resident resident, LocalDateTime householdCompositionDate, String householdCompositionReasonCode, String currentHouseMovementAddress) {
        this.resident = resident;
        this.householdCompositionDate = householdCompositionDate;
        this.householdCompositionReasonCode = householdCompositionReasonCode;
        this.currentHouseMovementAddress = currentHouseMovementAddress;
    }
}
