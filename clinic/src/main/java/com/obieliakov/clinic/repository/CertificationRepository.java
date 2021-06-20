package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
