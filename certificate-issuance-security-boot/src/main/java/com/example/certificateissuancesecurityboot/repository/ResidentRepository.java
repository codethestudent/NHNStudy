package com.example.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuance.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Integer>, ResidentRepositoryCustom {
    List<Resident> findAllByRegistrationBaseAddress(String registrationAddress);
}
