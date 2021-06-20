package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient extends Person {

    @Column(name = "insurance_number")
    private Integer insuranceNumber;

    @OneToMany(mappedBy = "patient")
    private Set<Diagnosis> diagnoses;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;
}
