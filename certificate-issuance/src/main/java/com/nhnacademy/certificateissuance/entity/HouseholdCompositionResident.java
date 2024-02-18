package com.nhnacademy.certificateissuance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;
    @ManyToOne
    @MapsId("householdSerialNumber")
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @OneToOne
    @MapsId("residentSerialNumber")
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "report_date")
    private LocalDateTime reportDate;
    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;
    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private int householdSerialNumber;

        @Column(name = "resident_serial_number")
        private int residentSerialNumber;
    }
}
