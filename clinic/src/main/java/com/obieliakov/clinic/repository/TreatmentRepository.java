package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
