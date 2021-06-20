package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "procedure")
@Getter
@Setter
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "procedure_type_id", foreignKey = @ForeignKey(name = "fk_procedure_type"))
    private ProcedureType procedureType;

    @ManyToMany
    @JoinTable(
            name = "procedure_equipment",
            joinColumns = {@JoinColumn(name = "procedure_id", foreignKey = @ForeignKey(name = "fk_equipment_procedure"))},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id", foreignKey = @ForeignKey(name = "fk_procedure_equipment"))}
    )
    private Set<Equipment> equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", foreignKey = @ForeignKey(name = "fk_procedure_treatment"))
    private Treatment treatment;

    @OneToMany(mappedBy = "procedure")
    private Set<Medicine> medicines;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointment_id", foreignKey = @ForeignKey(name = "fk_procedure_appointment"))
    private Appointment appointment;
}
