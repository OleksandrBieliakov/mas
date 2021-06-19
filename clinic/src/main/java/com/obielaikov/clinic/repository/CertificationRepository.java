package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
