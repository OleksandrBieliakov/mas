package com.obieliakov.clinic.dataloader;

import com.obieliakov.clinic.model.*;
import com.obieliakov.clinic.model.enums.AppointmentStatus;
import com.obieliakov.clinic.model.enums.Sex;
import com.obieliakov.clinic.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Profile("data")
@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final SpecializationRepository specializationRepository;
    private final CertificationRepository certificationRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final TreatmentRepository treatmentRepository;
    private final MedicineTypeRepository medicineTypeRepository;
    private final MedicineRepository medicineRepository;
    private final EquipmentRepository equipmentRepository;
    private final ProcedureTypeRepository procedureTypeRepository;
    private final ProcedureRepository procedureRepository;
    private final ExaminationTypeRepository examinationTypeRepository;
    private final ExaminationRepository examinationRepository;
    private final RoomRepository roomRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Patient patient1 = new Patient();
        patient1.setFirstName("Hagrid");
        patient1.setLastName("Rubeus");
        patient1.setBirthDate(ZonedDateTime.now().minusYears(60));
        patient1.setSex(Sex.MALE);
        patient1.setInsuranceNumber(123);

        Patient patient2 = new Patient();
        patient2.setFirstName("Luna");
        patient2.setLastName("Lovegood");
        patient2.setBirthDate(ZonedDateTime.now().minusYears(17));
        patient2.setSex(Sex.FEMALE);

        Patient patient3 = new Patient();
        patient3.setFirstName("Narcissa");
        patient3.setLastName("Malfoy");
        patient3.setBirthDate(ZonedDateTime.now().minusYears(40));
        patient3.setSex(Sex.FEMALE);
        patient3.setInsuranceNumber(456);

        Patient patient4 = new Patient();
        patient4.setFirstName("Neville");
        patient4.setLastName("Longbottom");
        patient4.setBirthDate(ZonedDateTime.now().minusYears(17));
        patient4.setSex(Sex.MALE);

        patientRepository.saveAll(List.of(patient1, patient2, patient3, patient4));


        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Severus");
        doctor1.setLastName("Snape");
        doctor1.setBirthDate(ZonedDateTime.now().minusYears(40));
        doctor1.setSex(Sex.MALE);
        doctor1.setHourlyRate(new BigDecimal(100));

        Doctor doctor2 = new Doctor();
        doctor2.setFirstName("Bellatrix");
        doctor2.setLastName("Lestrange");
        doctor2.setBirthDate(ZonedDateTime.now().minusYears(35));
        doctor2.setSex(Sex.FEMALE);
        doctor2.setHourlyRate(new BigDecimal(150));

        Doctor doctor3 = new Doctor();
        doctor3.setFirstName("Albus");
        doctor3.setLastName("Dumbledore");
        doctor3.setBirthDate(ZonedDateTime.now().minusYears(100));
        doctor3.setSex(Sex.MALE);
        doctor3.setHourlyRate(new BigDecimal(200));

        Doctor doctor4 = new Doctor();
        doctor4.setFirstName("Nymphadora");
        doctor4.setLastName("Tonks");
        doctor4.setBirthDate(ZonedDateTime.now().minusYears(30));
        doctor4.setSex(Sex.FEMALE);
        doctor4.setHourlyRate(new BigDecimal(100));


        Specialization specialization1 = new Specialization();
        specialization1.setTitle("physician");

        Specialization specialization2 = new Specialization();
        specialization2.setTitle("surgeon");

        Specialization specialization3 = new Specialization();
        specialization3.setTitle("ophthalmologist");

        Specialization specialization4 = new Specialization();
        specialization4.setTitle("dermatologist");

        specializationRepository.saveAll(List.of(specialization1, specialization2, specialization3, specialization4));


        doctor1.setSpecializations(Set.of(specialization1, specialization2));
        doctor2.setSpecializations(Set.of(specialization3));
        doctor3.setSpecializations(Set.of(specialization1, specialization4));
        doctor4.setSpecializations(Set.of(specialization2, specialization4));

        doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3, doctor4));


        Nurse nurse1 = new Nurse();
        nurse1.setFirstName("Ginny");
        nurse1.setLastName("Weasley");
        nurse1.setBirthDate(ZonedDateTime.now().minusYears(16));
        nurse1.setSex(Sex.FEMALE);
        nurse1.setHourlyRate(new BigDecimal(55));

        Nurse nurse2 = new Nurse();
        nurse2.setFirstName("Dudley");
        nurse2.setLastName("Dursley");
        nurse2.setBirthDate(ZonedDateTime.now().minusYears(19));
        nurse2.setSex(Sex.MALE);
        nurse2.setHourlyRate(new BigDecimal(55));

        Nurse nurse3 = new Nurse();
        nurse3.setFirstName("Oliver");
        nurse3.setLastName("Wood");
        nurse3.setBirthDate(ZonedDateTime.now().minusYears(23));
        nurse3.setSex(Sex.MALE);
        nurse3.setHourlyRate(new BigDecimal(60));

        Nurse nurse4 = new Nurse();
        nurse4.setFirstName("Pansy");
        nurse4.setLastName("Parkinson");
        nurse4.setBirthDate(ZonedDateTime.now().minusYears(17));
        nurse4.setSex(Sex.FEMALE);
        nurse4.setHourlyRate(new BigDecimal(50));


        Certification certification1 = new Certification();
        certification1.setTitle("first aid");

        Certification certification2 = new Certification();
        certification2.setTitle("surgeon assistant");

        Certification certification3 = new Certification();
        certification3.setTitle("ophthalmologist assistant");

        Certification certification4 = new Certification();
        certification4.setTitle("injections licence");

        certificationRepository.saveAll(List.of(certification1, certification2, certification3, certification4));


        nurse1.setCertifications(Set.of(certification1, certification2));
        nurse2.setCertifications(Set.of(certification1, certification3));
        nurse3.setCertifications(Set.of(certification1, certification4));
        nurse4.setCertifications(Set.of(certification4));

        nurseRepository.saveAll(List.of(nurse1, nurse2, nurse3, nurse4));


        Diagnosis diagnosis1 = new Diagnosis();
        diagnosis1.setTitle("diabetes");
        diagnosis1.setDateDiagnosed(ZonedDateTime.now().minusWeeks(2));
        diagnosis1.setPatient(patient1);

        Diagnosis diagnosis2 = new Diagnosis();
        diagnosis2.setTitle("flu");
        diagnosis2.setDateDiagnosed(ZonedDateTime.now().minusWeeks(2));
        diagnosis2.setDateWithdrawn(ZonedDateTime.now().minusWeeks(1));
        diagnosis2.setPatient(patient1);

        Diagnosis diagnosis3 = new Diagnosis();
        diagnosis3.setTitle("covid-19");
        diagnosis3.setDateDiagnosed(ZonedDateTime.now().minusDays(4));
        diagnosis3.setPatient(patient2);

        diagnosisRepository.saveAll(List.of(diagnosis1, diagnosis2, diagnosis3));

        Treatment treatment1 = new Treatment();
        treatment1.setDateStarted(diagnosis1.getDateDiagnosed());
        treatment1.setDiagnosis(diagnosis1);

        Treatment treatment2 = new Treatment();
        treatment2.setDateStarted(diagnosis2.getDateDiagnosed());
        treatment2.setDateEnded(diagnosis2.getDateWithdrawn());
        treatment2.setDiagnosis(diagnosis2);

        Treatment treatment3 = new Treatment();
        treatment3.setDateStarted(diagnosis3.getDateDiagnosed());
        treatment3.setDiagnosis(diagnosis3);

        treatmentRepository.saveAll(List.of(treatment1, treatment2, treatment3));


        MedicineType medicineType1 = new MedicineType();
        medicineType1.setTitle("antibiotic");

        MedicineType medicineType2 = new MedicineType();
        medicineType2.setTitle("aspirin");

        MedicineType medicineType3 = new MedicineType();
        medicineType3.setTitle("vitamin C");

        MedicineType medicineType4 = new MedicineType();
        medicineType4.setTitle("painkiller");

        medicineTypeRepository.saveAll(List.of(medicineType1, medicineType2, medicineType3, medicineType4));


        Medicine medicine1 = new Medicine();
        medicine1.setMedicineType(medicineType1);
        medicine1.setTreatment(treatment2);

        Medicine medicine2 = new Medicine();
        medicine2.setMedicineType(medicineType1);
        medicine2.setTreatment(treatment3);

        Medicine medicine3 = new Medicine();
        medicine3.setMedicineType(medicineType2);
        medicine3.setTreatment(treatment2);

        Medicine medicine4 = new Medicine();
        medicine4.setMedicineType(medicineType3);
        medicine4.setTreatment(treatment3);

        Medicine medicine5 = new Medicine();
        medicine5.setMedicineType(medicineType4);
        medicine5.setAmount(2);
        medicine5.setCost(new BigDecimal(20));

        medicineRepository.saveAll(List.of(medicine1, medicine2, medicine3, medicine4));


        Equipment equipment1 = new Equipment();
        equipment1.setTitle("X-ray machine");
        equipment1.setPricePerProcedure(new BigDecimal(40));

        Equipment equipment2 = new Equipment();
        equipment2.setTitle("surgeon saw");

        equipmentRepository.saveAll(List.of(equipment1, equipment2));


        Room room1 = new Room();
        room1.setRoomNo("101");

        Room room2 = new Room();
        room2.setRoomNo("102A");

        Room room3 = new Room();
        room3.setRoomNo("102B");

        Room room4 = new Room();
        room4.setRoomNo("204");

        roomRepository.saveAll(List.of(room1, room2, room3, room4));


        // booked procedure
        Appointment appointment1 = new Appointment();
        appointment1.setRoom(room1);
        appointment1.setStartDate(ZonedDateTime.now().plusDays(1));
        appointment1.setEndDate(ZonedDateTime.now().plusDays(1).plusMinutes(30));
        appointment1.setStatus(AppointmentStatus.BOOKED);
        appointment1.setDoctors(Set.of(doctor2));
        appointment1.setNurses(Set.of(nurse3));
        appointment1.setPatient(patient2);

        // booked procedure
        Appointment appointment2 = new Appointment();
        appointment2.setRoom(room2);
        appointment2.setStartDate(ZonedDateTime.now().plusDays(1).plusMinutes(30));
        appointment2.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(1));
        appointment2.setStatus(AppointmentStatus.BOOKED);
        appointment2.setNurses(Set.of(nurse3, nurse4));
        appointment2.setPatient(patient2);

        // booked procedure
        Appointment appointment3 = new Appointment();
        appointment3.setRoom(room3);
        appointment3.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(1));
        appointment3.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(1).plusMinutes(30));
        appointment3.setStatus(AppointmentStatus.BOOKED);
        appointment3.setNurses(Set.of(nurse3));
        appointment3.setPatient(patient3);

        // booked procedure
        Appointment appointment4 = new Appointment();
        appointment4.setRoom(room4);
        appointment4.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(1));
        appointment4.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(2).plusMinutes(30));
        appointment4.setStatus(AppointmentStatus.BOOKED);
        appointment4.setDoctors(Set.of(doctor2, doctor1));
        appointment4.setNurses(Set.of(nurse1, nurse2));
        appointment4.setPatient(patient4);

        //diagnosis 1 and 2
        Appointment appointment5 = new Appointment();
        appointment5.setRoom(room1);
        appointment5.setStartDate(diagnosis1.getDateDiagnosed().minusMinutes(30));
        appointment5.setEndDate(diagnosis1.getDateDiagnosed());
        appointment5.setStatus(AppointmentStatus.ATTENDED);
        appointment5.setDoctors(Set.of(doctor1));
        appointment5.setPatient(patient1);

        //diagnosis 3
        Appointment appointment6 = new Appointment();
        appointment6.setRoom(room2);
        appointment6.setStartDate(diagnosis3.getDateDiagnosed().minusMinutes(30));
        appointment6.setEndDate(diagnosis3.getDateDiagnosed());
        appointment6.setStatus(AppointmentStatus.ATTENDED);
        appointment6.setDoctors(Set.of(doctor3));
        appointment6.setPatient(patient2);

        // booked examination
        Appointment appointment7 = new Appointment();
        appointment7.setRoom(room3);
        appointment7.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(2));
        appointment7.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(2).plusMinutes(30));
        appointment7.setStatus(AppointmentStatus.BOOKED);
        appointment7.setDoctors(Set.of(doctor2));
        appointment7.setNurses(Set.of(nurse1, nurse2));
        appointment7.setPatient(patient3);

        // booked examination
        Appointment appointment8 = new Appointment();
        appointment8.setRoom(room4);
        appointment8.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(2).plusMinutes(30));
        appointment8.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(3));
        appointment8.setStatus(AppointmentStatus.BOOKED);
        appointment8.setDoctors(Set.of(doctor1, doctor3));
        appointment8.setPatient(patient1);

        // available examination
        Appointment appointment9 = new Appointment();
        appointment9.setRoom(room1);
        appointment9.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(3));
        appointment9.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(3).plusMinutes(30));
        appointment9.setStatus(AppointmentStatus.AVAILABLE);
        appointment9.setDoctors(Set.of(doctor4));

        // available examination
        Appointment appointment10 = new Appointment();
        appointment10.setRoom(room2);
        appointment10.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(3).plusMinutes(30));
        appointment10.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(4));
        appointment10.setStatus(AppointmentStatus.AVAILABLE);
        appointment10.setDoctors(Set.of(doctor1, doctor3));

        // available examination
        Appointment appointment11 = new Appointment();
        appointment11.setRoom(room3);
        appointment11.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(4));
        appointment11.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(4).plusMinutes(30));
        appointment11.setStatus(AppointmentStatus.AVAILABLE);
        appointment11.setDoctors(Set.of(doctor1));
        appointment11.setNurses(Set.of(nurse3, nurse4));

        // available examination
        Appointment appointment12 = new Appointment();
        appointment12.setRoom(room4);
        appointment12.setStartDate(ZonedDateTime.now().plusDays(1).plusHours(4).plusMinutes(30));
        appointment12.setEndDate(ZonedDateTime.now().plusDays(1).plusHours(5));
        appointment12.setStatus(AppointmentStatus.AVAILABLE);
        appointment12.setDoctors(Set.of(doctor3));
        appointment12.setNurses(Set.of(nurse1, nurse2));

        appointmentRepository.saveAll(List.of(appointment1, appointment2, appointment3, appointment4, appointment5,
                appointment6, appointment7, appointment8, appointment9, appointment10, appointment11, appointment12));


        ProcedureType procedureType1 = new ProcedureType();
        procedureType1.setTitle("X-ray");

        ProcedureType procedureType2 = new ProcedureType();
        procedureType2.setTitle("injection");

        ProcedureType procedureType3 = new ProcedureType();
        procedureType3.setTitle("bandage placement");

        ProcedureType procedureType4 = new ProcedureType();
        procedureType4.setTitle("amputation");

        procedureTypeRepository.saveAll(List.of(procedureType1, procedureType2, procedureType3, procedureType4));


        // booked
        Procedure procedure1 = new Procedure();
        procedure1.setProcedureType(procedureType1);
        procedure1.setEquipment(Set.of(equipment1));
        procedure1.setTreatment(treatment3);
        procedure1.setAppointment(appointment1);

        // booked
        Procedure procedure2 = new Procedure();
        procedure2.setProcedureType(procedureType2);
        procedure2.setTreatment(treatment3);
        procedure2.setAppointment(appointment2);

        // booked
        Procedure procedure3 = new Procedure();
        procedure3.setProcedureType(procedureType3);
        procedure3.setEquipment(Set.of(equipment1));
        procedure3.setAppointment(appointment3);

        // booked
        Procedure procedure4 = new Procedure();
        procedure4.setProcedureType(procedureType4);
        procedure4.setEquipment(Set.of(equipment1, equipment2));
        procedure4.setAppointment(appointment4);

        medicine5.setProcedure(procedure4);
        medicineRepository.save(medicine5);

        procedureRepository.saveAll(List.of(procedure1, procedure2, procedure3, procedure4));


        ExaminationType examinationType1 = new ExaminationType();
        examinationType1.setTitle("general");

        ExaminationType examinationType2 = new ExaminationType();
        examinationType2.setTitle("neurological");

        ExaminationType examinationType3 = new ExaminationType();
        examinationType3.setTitle("dermatological");

        examinationTypeRepository.saveAll(List.of(examinationType1, examinationType2, examinationType3));


        // visited
        Examination examination1 = new Examination();
        examination1.setExaminationType(examinationType1);
        examination1.setDiagnoses(Set.of(diagnosis1, diagnosis2));
        examination1.setAppointment(appointment5);

        // visited
        Examination examination2 = new Examination();
        examination2.setExaminationType(examinationType1);
        examination2.setDiagnoses(Set.of(diagnosis3));
        examination2.setAppointment(appointment6);

        // booked
        Examination examination3 = new Examination();
        examination3.setExaminationType(examinationType2);
        examination3.setAppointment(appointment7);

        // booked
        Examination examination4 = new Examination();
        examination4.setExaminationType(examinationType1);
        examination4.setAppointment(appointment8);

        // available
        Examination examination5 = new Examination();
        examination5.setExaminationType(examinationType3);
        examination5.setAppointment(appointment9);

        // available
        Examination examination6 = new Examination();
        examination6.setExaminationType(examinationType1);
        examination6.setAppointment(appointment10);

        // available
        Examination examination7 = new Examination();
        examination7.setExaminationType(examinationType1);
        examination7.setAppointment(appointment11);

        // available
        Examination examination8 = new Examination();
        examination8.setExaminationType(examinationType1);
        examination8.setAppointment(appointment12);

        examinationRepository.saveAll(List.of(examination1, examination2, examination3, examination4, examination5, examination6, examination7, examination8));
    }
}
