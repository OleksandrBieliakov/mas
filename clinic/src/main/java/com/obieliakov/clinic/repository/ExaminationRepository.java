package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
