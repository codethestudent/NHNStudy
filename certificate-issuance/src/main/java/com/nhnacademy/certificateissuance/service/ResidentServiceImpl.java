package com.nhnacademy.certificateissuance.service;

import com.nhnacademy.certificateissuance.domain.ResidentRegisterDto;
import com.nhnacademy.certificateissuance.entity.Resident;
import com.nhnacademy.certificateissuance.repository.ResidentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public Resident registerResident(ResidentRegisterDto residentRegisterDto) {
        Resident resident = new Resident();
        BeanUtils.copyProperties(residentRegisterDto, resident);
        return residentRepository.save(resident);
    }

    @Override
    public Resident updateResident(int serialNumber, ResidentRegisterDto residentRegisterDto) {
        Resident resident = residentRepository.findById(serialNumber)
                .orElseThrow(() -> new EntityNotFoundException("Resident not found"));
        BeanUtils.copyProperties(residentRegisterDto, resident);
        return residentRepository.save(resident);
    }
}
