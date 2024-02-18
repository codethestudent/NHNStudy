package com.nhnacademy.certificateissuance.repository;

import com.nhnacademy.certificateissuance.entity.QHousehold;
import com.nhnacademy.certificateissuance.entity.QHouseholdCompositionResident;
import com.nhnacademy.certificateissuance.entity.QResident;
import com.nhnacademy.certificateissuance.entity.Resident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ResidentRepositoryImpl extends QuerydslRepositorySupport implements ResidentRepositoryCustom {
    public ResidentRepositoryImpl() {
        super(Resident.class);
    }

    @Override
    public List<Resident> getAllResidentsByHousehold() {
        QResident resident = QResident.resident;
        QHousehold household = QHousehold.household;
        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;

        return from(resident)
                .innerJoin(resident.household, household)
                .innerJoin(resident.householdCompositionResident, householdCompositionResident)
                .select(resident)
                .distinct()
                .fetch();
    }
}
