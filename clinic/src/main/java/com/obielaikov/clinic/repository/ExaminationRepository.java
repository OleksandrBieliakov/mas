package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
