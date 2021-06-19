package com.obielaikov.clinic.dataloader;

import com.obielaikov.clinic.model.*;
import com.obielaikov.clinic.model.enums.Sex;
import com.obielaikov.clinic.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final SpecializationRepository specializationRepository;
    private final CertificationRepository certificationRepository;

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
    }
}
