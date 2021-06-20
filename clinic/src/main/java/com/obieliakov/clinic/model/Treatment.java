package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "treatment")
@Getter
@Setter
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_started", nullable = false)
    private ZonedDateTime dateStarted;

    @Column(name = "date_ended")
    private ZonedDateTime dateEnded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diagnosis_id", foreignKey = @ForeignKey(name = "fk_treatment_diagnosis"))
    private Diagnosis diagnosis;

    @OneToMany(mappedBy = "treatment")
    private Set<Medicine> medicines;

    @OneToMany(mappedBy = "treatment")
    private Set<Procedure> procedures;
}
