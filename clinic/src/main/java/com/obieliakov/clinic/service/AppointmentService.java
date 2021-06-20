package com.obieliakov.clinic.service;

import com.obieliakov.clinic.model.Appointment;
import com.obieliakov.clinic.model.Doctor;
import com.obieliakov.clinic.model.ExaminationType;
import com.obieliakov.clinic.model.ProcedureType;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import com.obieliakov.clinic.repository.AppointmentRepository;
import com.obieliakov.clinic.repository.DoctorRepository;
import com.obieliakov.clinic.repository.ExaminationTypeRepository;
import com.obieliakov.clinic.repository.ProcedureTypeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<Appointment> listBooked() {
        return appointmentRepository.findByStatusOrderByStartDate(AppointmentStatus.BOOKED);
    }

    @Transactional(readOnly = true)
    public List<ExaminationType> listAllExaminationTypes() {
        return examinationTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ProcedureType> listAllProcedureTypes() {
        return procedureTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Appointment> listAvailable(String type, Long doctorId) {
        log.debug("List available by type {}, doctor id {}", type, doctorId);
        return appointmentRepository.findByStatusOrderByStartDate(AppointmentStatus.AVAILABLE);
    }
}
