package com.nhnacademy.certificateissuancesecurityboot.service;

import com.nhnacademy.certificateissuancesecurityboot.domain.ResidentRegisterDto;
import com.nhnacademy.certificateissuancesecurityboot.entity.Resident;
import com.nhnacademy.certificateissuancesecurityboot.repository.ResidentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

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

    @Override
    public Resident getResident(String id) {
        Resident resident = residentRepository.findById(id);
        if (Objects.isNull(resident)) {
            throw new EntityNotFoundException(id + " matching resident not found");
        }
        return resident;
    }
}
