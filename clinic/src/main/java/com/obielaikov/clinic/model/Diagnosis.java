package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "diagnosis")
@Getter
@Setter
public class Diagnosis {

    private static final int TITLE_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = TITLE_MAX_LENGTH)
    private String title;

    @Column(name = "date_diagnosed", nullable = false)
    private ZonedDateTime dateDiagnosed;

    @Column(name = "date_withdrawn")
    private ZonedDateTime dateWithdrawn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="patient_id", foreignKey = @ForeignKey(name = "fk_diagnosis_patient"))
    private Patient patient;

    @OneToMany(mappedBy = "diagnosis")
    private Set<Treatment> treatments;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Examination> examinations;
}
