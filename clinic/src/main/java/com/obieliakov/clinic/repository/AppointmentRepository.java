package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Appointment;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStatusOrderByStartDate(AppointmentStatus status);
}
