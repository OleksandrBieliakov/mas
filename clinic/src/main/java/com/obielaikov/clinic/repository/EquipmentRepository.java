package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
