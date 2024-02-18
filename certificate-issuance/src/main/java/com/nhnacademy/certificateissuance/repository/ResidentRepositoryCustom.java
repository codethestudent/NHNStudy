package com.nhnacademy.certificateissuance.repository;

import com.nhnacademy.certificateissuance.entity.Resident;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ResidentRepositoryCustom {
    List<Resident> getAllResidentsByHousehold();
}
