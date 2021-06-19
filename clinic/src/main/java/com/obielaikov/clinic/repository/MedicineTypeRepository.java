package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.MedicineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineTypeRepository extends JpaRepository<MedicineType, Long> {
}
