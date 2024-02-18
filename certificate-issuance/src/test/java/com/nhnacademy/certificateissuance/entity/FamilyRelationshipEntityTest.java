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
public class FamilyRelationshipEntityTest {
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
        FamilyRelationship familyRelationship = new FamilyRelationship();
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(12345, 12345);
        familyRelationship.setPk(pk);
        familyRelationship.setFamilyResident(resident);
        familyRelationship.setBaseResident(resident);
        familyRelationship.setFamilyRelationshipCode("PARENT");

        entityManager.persist(familyRelationship);
        FamilyRelationship familyRelationship1 = entityManager.find(FamilyRelationship.class, pk);
        Assertions.assertEquals(familyRelationship1, familyRelationship);
    }
}
