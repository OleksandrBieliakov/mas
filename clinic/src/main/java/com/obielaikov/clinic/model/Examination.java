package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "examination")
@Getter
@Setter
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="examination_type_id", foreignKey = @ForeignKey(name = "fk_examination_type"))
    private ExaminationType examinationType;

    @ManyToMany
    @JoinTable(
            name = "examination_diagnosis",
            joinColumns = {@JoinColumn(name = "examination_id", foreignKey = @ForeignKey(name = "fk_diagnosis_examination"))},
            inverseJoinColumns = {@JoinColumn(name = "diagnosis_id", foreignKey = @ForeignKey(name = "fk_examination_diagnosis"))}
    )
    private Set<Diagnosis> diagnoses;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="appointment_id", foreignKey = @ForeignKey(name = "fk_examination_appointment"))
    private Appointment appointment;
}
