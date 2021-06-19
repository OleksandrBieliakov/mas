package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor extends MedicalStaff {

    @ManyToMany
    @JoinTable(
            name = "doctor_specialization",
            joinColumns = {@JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "fk_specialization_doctor"))},
            inverseJoinColumns = {@JoinColumn(name = "specialization_id", foreignKey = @ForeignKey(name = "fk_doctor_specialization"))}
    )
    @Size(min = 1)
    private Set<Specialization> specializations;

    @ManyToMany(mappedBy = "doctors")
    private Set<Appointment> appointments;
}
