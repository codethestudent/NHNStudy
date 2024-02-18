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

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class HouseholdEntityTest {
    @PersistenceContext
    EntityManager entityManager;

    Resident resident;

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
    }

    @Test
    void test() {
        Household household = new Household();
        household.setHouseholdSerialNumber(55555);
        household.setResident(resident);
        household.setHouseholdCompositionDate(LocalDateTime.now());
        household.setHouseholdCompositionReasonCode("Family");
        household.setCurrentHouseMovementAddress("내동 1142-1 ");

        entityManager.persist(household);
        Household household1 = entityManager.find(Household.class, 55555);
        Assertions.assertEquals(household1, household);
    }
}

