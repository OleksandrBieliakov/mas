package com.obieliakov.clinic.service;

import com.obieliakov.clinic.model.*;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import com.obieliakov.clinic.repository.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AppointmentRepository appointmentRepository;
    private final ExaminationTypeRepository examinationTypeRepository;
    private final ProcedureTypeRepository procedureTypeRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment findById(Long id) {
        return appointmentRepository.getById(id);
    }

    public List<Appointment> listBooked() {
        return appointmentRepository.findByStatusOrderByStartDate(AppointmentStatus.BOOKED);
    }

    public List<ExaminationType> listAllExaminationTypes() {
        return examinationTypeRepository.findAll();
    }

    public List<ProcedureType> listAllProcedureTypes() {
        return procedureTypeRepository.findAll();
    }

    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Patient> listAllPatients() {
        return patientRepository.findAll();
    }

    public List<Appointment> listAvailable(String type, Long doctorId, String from, String to) throws Exception{
        log.debug("List available by type {}, doctor id {}, from {}, to {}", type, doctorId, from, to);

        if(type == null || type.length() == 0) {
            throw new IllegalArgumentException("Type of the appointment must not be null.");
        }

        String[] typeParts = type.split(" ");
        boolean isExamination;
        if(typeParts[0].equals("examinationTypeId")) {
            isExamination = true;
        } else if(typeParts[0].equals("procedureTypeId")) {
            isExamination = false;
        } else {
            throw new IllegalArgumentException("Illegal format type of the appointment.");
        }
        long appoinmentTypeId = Long.parseLong(typeParts[1]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        ZonedDateTime fromZonedDateTime;
        ZonedDateTime toZonedDateTime;
        if (from != null) {
            LocalDateTime fromLocalDateTime = LocalDateTime.parse(from, formatter);
            fromZonedDateTime = fromLocalDateTime.atZone(ZonedDateTime.now().getZone());
        } else {
            fromZonedDateTime = ZonedDateTime.now();
        }
        if (to != null) {
            LocalDateTime toLocalDateTime = LocalDateTime.parse(to, formatter);
            toZonedDateTime = toLocalDateTime.atZone(ZonedDateTime.now().getZone());
        } else {
            toZonedDateTime = fromZonedDateTime.plusYears(1);
        }

        if(toZonedDateTime.isBefore(fromZonedDateTime)) {
            throw new IllegalArgumentException("Illegal time range, 'from' must be before 'to'.");
        }

        log.debug("List available from {}, to {}", fromZonedDateTime, toZonedDateTime);
        log.debug(appointmentRepository.findByStatusOrderByStartDate(AppointmentStatus.AVAILABLE).size() + "");

        if(isExamination && doctorId != null) {
            return appointmentRepository.queryByExaminationTypeAndDoctor(appoinmentTypeId, doctorId, fromZonedDateTime, toZonedDateTime, AppointmentStatus.AVAILABLE);
        }
        return appointmentRepository.findByStatusOrderByStartDate(AppointmentStatus.AVAILABLE);
    }
}
