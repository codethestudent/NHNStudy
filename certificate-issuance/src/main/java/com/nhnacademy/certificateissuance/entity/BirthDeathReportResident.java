package com.nhnacademy.certificateissuance.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
    @EmbeddedId
    private Pk pk;

    @ManyToOne
    @MapsId("residentSerialNumber")
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "report_resident_serial_number")
    private int reportResidentSerialNumber;

    @Column(name = "birth_death_report_date")
    private LocalDateTime birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "resident_serial_number")
        private int residentSerialNumber;

        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;
    }
}
