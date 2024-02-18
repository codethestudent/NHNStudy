package com.nhnacademy.certificateissuance.entity;


import com.nhnacademy.certificateissuance.config.RootConfig;
import com.nhnacademy.certificateissuance.config.WebConfig;
import org.junit.jupiter.api.Assertions;
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

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class ResidentEntityTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test1() {
        Resident resident = new Resident();
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

        Resident resident1 = entityManager.find(Resident.class, 12345);
        assertThat(resident1).isEqualTo(resident);
    }
}
