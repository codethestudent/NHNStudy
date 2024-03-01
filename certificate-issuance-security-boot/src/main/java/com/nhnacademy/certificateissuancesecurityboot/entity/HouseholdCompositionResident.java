package com.nhnacademy.certificateissuancesecurityboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Resident resident;

    @Column(name = "report_date")
    private LocalDateTime reportDate;
    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;
    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    public HouseholdCompositionResident(Pk pk,
                                        Household household,
                                        Resident resident,
                                        LocalDateTime reportDate,
                                        String householdRelationshipCode,
                                        String householdCompositionChangeReasonCode) {
        this.pk = pk;
        this.household = household;
        this.resident = resident;
        this.reportDate = reportDate;
        this.householdRelationshipCode = householdRelationshipCode;
        this.householdCompositionChangeReasonCode = householdCompositionChangeReasonCode;
    }

    public HouseholdCompositionResident() {
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    @Data
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private int householdSerialNumber;

        @Column(name = "resident_serial_number")
        private int residentSerialNumber;
    }
}
