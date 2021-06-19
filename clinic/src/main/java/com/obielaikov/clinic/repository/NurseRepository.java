package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
