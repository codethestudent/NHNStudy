package com.nhnacademy.certificateissuance.service;

import com.nhnacademy.certificateissuance.domain.BirthReportDto;
import com.nhnacademy.certificateissuance.entity.BirthDeathReportResident;
import com.nhnacademy.certificateissuance.entity.Resident;
import com.nhnacademy.certificateissuance.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.certificateissuance.repository.ResidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private final ResidentRepository residentRepository;

    public BirthDeathReportResidentServiceImpl(BirthDeathReportResidentRepository birthDeathReportResidentRepository,
                                               ResidentRepository residentRepository) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public BirthDeathReportResident registerResidentBirth(int serialNumber, BirthReportDto birthReportDto) {
        Optional<Resident> resident = residentRepository.findById(serialNumber);
        Optional<Resident> reportResident = residentRepository.findById(birthReportDto.getReportResidentSerialNumber());

        if (resident.isEmpty() || reportResident.isEmpty()) {
            throw new EntityNotFoundException("Resident not found");
        }

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();
        BeanUtils.copyProperties(birthReportDto, birthDeathReportResident);
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(
                serialNumber,
                birthReportDto.getBirthDeathTypeCode(),
                birthReportDto.getReportResidentSerialNumber()
        );
        birthDeathReportResident.setResident(resident.get());
        birthDeathReportResident.setReportResident(reportResident.get());
        birthDeathReportResident.setPk(pk);
        return birthDeathReportResidentRepository.save(birthDeathReportResident);
    }

    @Override
    public BirthDeathReportResident updateResidentBirth(int serialNumber, int targetSerialNumber, BirthReportDto birthReportDto) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(
                targetSerialNumber,
                "출생",
                serialNumber
        );
        Optional<BirthDeathReportResident> birthDeathReportResidentOpt = birthDeathReportResidentRepository.findById(pk);
        Optional<Resident> reportResident = residentRepository.findById(serialNumber);

        if (birthDeathReportResidentOpt.isPresent() && reportResident.isPresent()) {
            BirthDeathReportResident birthDeathReportResident = birthDeathReportResidentOpt.get();
            BeanUtils.copyProperties(birthReportDto, birthDeathReportResident);
            birthDeathReportResident.setReportResident(reportResident.get());

            return birthDeathReportResidentRepository.save(birthDeathReportResident);
        } else {
            throw new EntityNotFoundException("BirthDeathReportResident not found");
        }
    }

    @Override
    public void deleteResidentBirth(int serialNumber, int targetSerialNumber) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(
                targetSerialNumber,
                "출생",
                serialNumber
        );
        if (!birthDeathReportResidentRepository.existsById(pk)) {
            throw new EntityNotFoundException("birthDeathReportResident not found");
        } else {
            birthDeathReportResidentRepository.deleteById(pk);
        }
    }
}
