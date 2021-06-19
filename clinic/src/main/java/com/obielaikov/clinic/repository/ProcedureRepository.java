package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
}
