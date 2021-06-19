package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.ExaminationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationTypeRepository extends JpaRepository<ExaminationType, Long> {
}
