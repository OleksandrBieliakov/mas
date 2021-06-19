package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.ProcedureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureTypeRepository extends JpaRepository<ProcedureType, Long> {
}
