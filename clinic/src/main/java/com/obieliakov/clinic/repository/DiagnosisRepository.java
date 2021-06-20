package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
