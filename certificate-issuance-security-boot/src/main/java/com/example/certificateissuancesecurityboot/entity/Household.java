package com.example.certificateissuancesecurityboot.entity;

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

}
