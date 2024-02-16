package com.nhnacademy.certificateissuance.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;
    @ManyToOne
    @MapsId("familyResidentSerialNumber")
    @JoinColumn(name = "resident_serial_number")
    private Resident familyResident;

    @ManyToOne
    @MapsId("baseResidentSerialNumber")
    @JoinColumn(name = "resident_serial_number")
    private Resident baseResident;
    private String familyRelationshipCode;

    @NoArgsConstructor
    @Embeddable
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private int familyResidentSerialNumber;

        @Column(name = "base_resident_serial_number")
        private int baseResidentSerialNumber;
    }
}
