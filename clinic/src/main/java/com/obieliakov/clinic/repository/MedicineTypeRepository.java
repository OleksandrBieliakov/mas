package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineTypeRepository extends JpaRepository<MedicineType, Long> {
}
