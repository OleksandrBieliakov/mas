package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Appointment;
import com.obielaikov.clinic.model.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStatusOrderByStartDate(AppointmentStatus status);
}
