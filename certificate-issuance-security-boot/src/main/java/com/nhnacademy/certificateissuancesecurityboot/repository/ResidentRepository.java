package com.nhnacademy.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Integer>, ResidentRepositoryCustom {
    Resident findByResidentSerialNumber(int residentSerialNumber);

    List<Resident> findAllByRegistrationBaseAddress(String registrationAddress);

    Resident findById(String id);
}
