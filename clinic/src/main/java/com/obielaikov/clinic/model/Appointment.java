package com.obielaikov.clinic.model;

import com.obielaikov.clinic.model.enums.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private ZonedDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private ZonedDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = AppointmentStatus.MAX_LENGTH)
    private AppointmentStatus status;

    @OneToOne(mappedBy = "appointment")
    private Examination examination;

    @OneToOne(mappedBy = "appointment")
    private Procedure procedure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id", foreignKey = @ForeignKey(name = "fk_appointment_room"))
    private Room room;

    @ManyToMany
    @JoinTable(
            name = "appointment_doctor",
            joinColumns = {@JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_doctor_appointment"))},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "fk_appointment_doctor"))}
    )
    private Set<Doctor> doctors;

    @ManyToMany
    @JoinTable(
            name = "appointment_nurse",
            joinColumns = {@JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_nurse_appointment"))},
            inverseJoinColumns = {@JoinColumn(name = "nurse_id", foreignKey = @ForeignKey(name = "fk_appointment_nurse"))}
    )
    private Set<Nurse> nurses;
}
