package com.nhnacademy.certificateissuance.controller;

import com.nhnacademy.certificateissuance.domain.BirthReportDto;
import com.nhnacademy.certificateissuance.domain.FamilyRelationshipDto;
import com.nhnacademy.certificateissuance.domain.ResidentRegisterDto;
import com.nhnacademy.certificateissuance.entity.BirthDeathReportResident;
import com.nhnacademy.certificateissuance.entity.FamilyRelationship;
import com.nhnacademy.certificateissuance.entity.Resident;
import com.nhnacademy.certificateissuance.service.BirthDeathReportResidentService;
import com.nhnacademy.certificateissuance.service.FamilyRelationshipService;
import com.nhnacademy.certificateissuance.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {
    private final ResidentService residentService;
    private final FamilyRelationshipService familyRelationshipService;
    private final BirthDeathReportResidentService birthDeathReportResidentService;

    public ResidentRestController(ResidentService residentService,
                                  FamilyRelationshipService familyRelationshipService,
                                  BirthDeathReportResidentService birthDeathReportResidentService) {
        this.residentService = residentService;
        this.familyRelationshipService = familyRelationshipService;
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    // 주민 등록
    @PostMapping
    public ResponseEntity<Resident> registerResident(@RequestBody ResidentRegisterDto residentRegisterDto) {
        Resident resident = residentService.registerResident(residentRegisterDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resident);
    }

    // 주민 수정
    @PutMapping("/{serialNumber}")
    public ResponseEntity<Resident> updateResident(@PathVariable int serialNumber,
                                                   @RequestBody ResidentRegisterDto residentRegisterDto) {
        Resident resident = residentService.updateResident(serialNumber, residentRegisterDto);
        return ResponseEntity.ok(resident);
    }

    //가족관계 등록
    @PostMapping("/{serialNumber}/relationship")
    public ResponseEntity<FamilyRelationship> registerFamilyRelationship(@PathVariable int serialNumber,
                                                                         @RequestBody FamilyRelationshipDto familyRelationshipDto) {
        FamilyRelationship familyRelationship = familyRelationshipService.registerFamilyRelationship(serialNumber, familyRelationshipDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(familyRelationship);
    }

    @PutMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<FamilyRelationship> updateFamilyRelationship(@PathVariable int serialNumber,
                                                                       @PathVariable int familySerialNumber,
                                                                       @RequestBody FamilyRelationshipDto familyRelationshipDto) {
        FamilyRelationship familyRelationship = familyRelationshipService.updateFamilyRelationship(serialNumber, familySerialNumber, familyRelationshipDto);
        return ResponseEntity.ok(familyRelationship);
    }

    // 가족관계 삭제
    @DeleteMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<FamilyRelationship> deleteFamilyRelationship(@PathVariable int serialNumber,
                                                                       @PathVariable int familySerialNumber) {
        try {
            familyRelationshipService.deleteFamilyRelationship(serialNumber, familySerialNumber);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 출생 신고
    @PostMapping("/{serialNumber}/birth")
    public ResponseEntity<BirthDeathReportResident> registerResidentBirth(@PathVariable int serialNumber,
                                                                          @RequestBody BirthReportDto birthReportDto) {
        BirthDeathReportResident birthDeathReportResident = birthDeathReportResidentService.registerResidentBirth(serialNumber, birthReportDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(birthDeathReportResident);
    }

    @PutMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<BirthDeathReportResident> updateResidentBirth(@PathVariable int serialNumber,
                                                                        @PathVariable int targetSerialNumber,
                                                                        @RequestBody BirthReportDto birthReportDto) {
        BirthDeathReportResident birthDeathReportResident = birthDeathReportResidentService.updateResidentBirth(serialNumber, targetSerialNumber, birthReportDto);
        return ResponseEntity.ok(birthDeathReportResident);
    }

    @DeleteMapping("/{serialNumber}/birth/{targetSerialNumber}")
    public ResponseEntity<?> deleteResidentBirth(@PathVariable int serialNumber,
                                                 @PathVariable int targetSerialNumber) {
        try {
            birthDeathReportResidentService.deleteResidentBirth(serialNumber, targetSerialNumber);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
