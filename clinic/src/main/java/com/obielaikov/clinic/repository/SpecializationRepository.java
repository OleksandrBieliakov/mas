package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
