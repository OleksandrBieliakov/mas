package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
