package com.example.certificateissuancesecurityboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resident")
@Getter
@Setter
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "resident")
    private Household household;

    @OneToOne(mappedBy = "resident")
    private HouseholdCompositionResident householdCompositionResident;
}
