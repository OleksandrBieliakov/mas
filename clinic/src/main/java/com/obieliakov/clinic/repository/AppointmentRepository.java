package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Appointment;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByStatusOrderByStartDate(AppointmentStatus status);


    @Query("select a from Appointment a join Examination e join Doctor d " +
            "where e.examinationType.id = :examinationTypeId " +
            "and d.id = :doctorId " +
            "and a.startDate between :from and :to " +
            "and a.status = :status")
    List<Appointment> queryByExaminationTypeAndDoctorAndStartTimeRangeAndStatus(@Param("examinationTypeId") Long examinationTypeId,
                                                                                @Param("doctorId") Long doctorId,
                                                                                @Param("from") ZonedDateTime from,
                                                                                @Param("to") ZonedDateTime to,
                                                                                @Param("status") AppointmentStatus status);
}
