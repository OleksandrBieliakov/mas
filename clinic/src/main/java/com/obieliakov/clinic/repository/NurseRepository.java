package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
