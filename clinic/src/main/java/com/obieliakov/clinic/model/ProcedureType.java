package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "procedure_type")
@Getter
@Setter
public class ProcedureType {

    private static final int TITLE_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = TITLE_MAX_LENGTH)
    private String title;

    @OneToMany(mappedBy = "procedureType")
    private Set<Procedure> procedures;
}
