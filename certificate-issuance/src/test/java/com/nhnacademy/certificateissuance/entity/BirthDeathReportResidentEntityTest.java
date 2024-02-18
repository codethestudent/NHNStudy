package com.nhnacademy.certificateissuance.entity;

import com.nhnacademy.certificateissuance.config.RootConfig;
import com.nhnacademy.certificateissuance.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class BirthDeathReportResidentEntityTest {
    @PersistenceContext
    EntityManager entityManager;

    Resident resident;
    Resident reportResident;

    @BeforeEach
    void setup() {
        resident = new Resident();
        resident.setResidentSerialNumber(12345);
        resident.setName("resident");
        resident.setResidentRegistrationNumber("12345");
        resident.setGenderCode("asdf");
        resident.setBirthDate(LocalDateTime.now());
        resident.setBirthPlaceCode("birthplacecode");
        resident.setDeathDate(LocalDateTime.now());
        resident.setDeathPlaceCode("right here");
        resident.setDeathPlaceAddress("right here");
        entityManager.persist(resident);

        reportResident = new Resident();
        reportResident.setResidentSerialNumber(1222);
        reportResident.setName("reportResident");
        reportResident.setResidentRegistrationNumber("12345");
        reportResident.setGenderCode("asdf");
        reportResident.setBirthDate(LocalDateTime.now());
        reportResident.setBirthPlaceCode("birthplacecode");
        reportResident.setDeathDate(LocalDateTime.now());
        reportResident.setDeathPlaceCode("right here");
        reportResident.setDeathPlaceAddress("right here");
        entityManager.persist(reportResident);
    }

    @Test
    void test1() {
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(12345, "BIRTH", 1222);
        birthDeathReportResident.setPk(pk);
        birthDeathReportResident.setResident(resident);
        birthDeathReportResident.setReportResident(reportResident);
        birthDeathReportResident.setBirthDeathReportDate(LocalDate.now());
        birthDeathReportResident.setBirthReportQualificationsCode("asdf");
        birthDeathReportResident.setDeathReportQualificationsCode("adsf");
        birthDeathReportResident.setEmailAddress("asdf@asdf.com");
        birthDeathReportResident.setPhoneNumber("010-1010-1010");

        entityManager.persist(birthDeathReportResident);

        BirthDeathReportResident birthDeathReportResident1 = entityManager.find(BirthDeathReportResident.class, pk);
        assertThat(birthDeathReportResident1).isNotNull();
        assertThat(birthDeathReportResident1).isEqualTo(birthDeathReportResident);
        assertThat(birthDeathReportResident1.getResident()).isEqualTo(resident);
        assertThat(birthDeathReportResident1.getPk()).isEqualTo(pk);
    }
}
