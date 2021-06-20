package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.ProcedureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureTypeRepository extends JpaRepository<ProcedureType, Long> {
}
