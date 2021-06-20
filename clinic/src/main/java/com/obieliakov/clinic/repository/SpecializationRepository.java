package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
