package com.nhnacademy.certificateissuance.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;
    @ManyToOne
    @MapsId("familyResidentSerialNumber")
    @JoinColumn(name = "family_resident_serial_number")
    private Resident familyResident;

    @ManyToOne
    @MapsId("baseResidentSerialNumber")
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private int familyResidentSerialNumber;

        @Column(name = "base_resident_serial_number")
        private int baseResidentSerialNumber;
    }
}
