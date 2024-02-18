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
public class HouseholdMovementAddressEntityTest {
    @PersistenceContext
    EntityManager entityManager;

    Resident resident;
    Household household;

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

        household = new Household();
        household.setHouseholdSerialNumber(55555);
        household.setResident(resident);
        household.setHouseholdCompositionDate(LocalDateTime.now());
        household.setHouseholdCompositionReasonCode("Family");
        household.setCurrentHouseMovementAddress("내동 1142-1 ");

        entityManager.persist(household);
    }

    @Test
    void test() {
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress();
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(1234, LocalDateTime.now());
        householdMovementAddress.setPk(pk);
        householdMovementAddress.setHousehold(household);
        householdMovementAddress.setHouseMovementAddress("asdf");
        householdMovementAddress.setLastAddressYn("1992");

        entityManager.persist(householdMovementAddress);
        HouseholdMovementAddress householdMovementAddress1 = entityManager.find(HouseholdMovementAddress.class, pk);
        Assertions.assertNotNull(householdMovementAddress1);
        Assertions.assertEquals(householdMovementAddress1, householdMovementAddress);
    }
}
