package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
}
