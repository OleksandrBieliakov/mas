package com.obielaikov.clinic.service;

import com.obielaikov.clinic.model.Appointment;
import com.obielaikov.clinic.model.Doctor;
import com.obielaikov.clinic.model.ExaminationType;
import com.obielaikov.clinic.model.ProcedureType;
import com.obielaikov.clinic.model.enums.AppointmentStatus;
import com.obielaikov.clinic.repository.AppointmentRepository;
import com.obielaikov.clinic.repository.DoctorRepository;
import com.obielaikov.clinic.repository.ExaminationTypeRepository;
import com.obielaikov.clinic.repository.ProcedureTypeRepository;
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
}
