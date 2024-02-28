package com.example.certificateissuancesecurityboot.repository;

import com.nhnacademy.certificateissuance.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long> {
}
