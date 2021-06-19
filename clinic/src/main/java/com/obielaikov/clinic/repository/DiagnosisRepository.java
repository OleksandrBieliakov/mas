package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}