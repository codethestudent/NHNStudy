package com.nhnacademy.certificateissuance.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    private int residentSerialNumber;

    private String name;
    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber;
    @Column(name = "gender_code")
    private String genderCode;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "birth_place_code")
    private String birthPlaceCode;
    @Column(name = "registration_base_address")
    private String registrationBaseAddress;
    @Column(name = "death_date")
    private LocalDateTime deathDate;
    @Column(name = "death_place_code")
    private String deathPlaceCode;
    @Column(name = "death_place_address")
    private String deathPlaceAddress;

    @OneToMany(mappedBy = "baseResident")
    private Set<FamilyRelationship> baseRelationships = new HashSet<>();
    @OneToMany(mappedBy = "familyResident")
    private Set<FamilyRelationship> familyRelationships = new HashSet<>();
    @OneToMany(mappedBy = "resident")
    private Set<BirthDeathReportResident> birthDeathReportResidents = new HashSet<>();
    @OneToMany(mappedBy = "resident")
    private Set<HouseholdCompositionResident> householdCompositionResidents = new HashSet<>();
}
