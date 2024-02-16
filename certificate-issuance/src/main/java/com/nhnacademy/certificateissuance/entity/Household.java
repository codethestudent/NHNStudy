package com.nhnacademy.certificateissuance.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "household")
public class Household {
    @Id
    @Column(name = "household_serial_number")
    private int householdSerialNumber;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @Column(name = "household_composition_date")
    private LocalDateTime householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @OneToMany(mappedBy = "household")
    private Set<HouseholdCompositionResident> householdCompositionResidentSet = new HashSet<>();
    @OneToMany(mappedBy = "household")
    private Set<HouseholdMovementAddress> householdMovementAddresses = new HashSet<>();
}
