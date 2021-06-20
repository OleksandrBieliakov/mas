package com.obieliakov.clinic.service;

import com.obieliakov.clinic.model.*;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import com.obieliakov.clinic.repository.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.obieliakov.clinic.model.QAppointment.appointment;
import static com.obieliakov.clinic.model.QDoctor.doctor;
import static com.obieliakov.clinic.model.QExamination.examination;
import static com.obieliakov.clinic.model.QProcedure.procedure;
import static com.obieliakov.clinic.model.enums.AppointmentStatus.AVAILABLE;
import static com.querydsl.core.types.Order.ASC;

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

    @PersistenceContext
    private final EntityManager entityManager;

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

        JPAQuery<Appointment> query = new JPAQuery<>(entityManager);

        query.from(appointment);

        BooleanBuilder bb = new BooleanBuilder();

        if (isExamination) {
            query.join(appointment.examination, examination);
            bb.and(examination.examinationType.id.eq(appoinmentTypeId));
        } else {
            query.join(appointment.procedure, procedure);
            bb.and(procedure.procedureType.id.eq(appoinmentTypeId));
        }

        if (doctorId != null) {
            query.join(appointment.doctors, doctor);
            bb.and(doctor.id.eq(doctorId));
        }

        bb.and(appointment.startDate.goe(fromZonedDateTime));
        bb.and(appointment.startDate.loe(toZonedDateTime));

        bb.and(appointment.status.eq(AVAILABLE));

        query.where(bb.getValue());

        query.orderBy(new OrderSpecifier<>(ASC, appointment.startDate));

        return query.fetch();
    }

    public void book(Long appointmentId, Long patientId) {
        Appointment appointment = appointmentRepository.getById(appointmentId);
        Patient patient = patientRepository.getById(patientId);
        appointment.setPatient(patient);
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointmentRepository.save(appointment);
    }
}
