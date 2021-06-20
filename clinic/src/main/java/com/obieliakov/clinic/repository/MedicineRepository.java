package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
