package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.ExaminationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationTypeRepository extends JpaRepository<ExaminationType, Long> {
}
