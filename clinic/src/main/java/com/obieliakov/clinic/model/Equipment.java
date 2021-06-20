package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "equipment")
@Getter
@Setter
public class Equipment {

    private static final int TITLE_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = TITLE_MAX_LENGTH)
    private String title;

    @Column(name = "price_per_procedure")
    private BigDecimal pricePerProcedure;

    @ManyToMany(mappedBy = "equipment")
    private Set<Procedure> procedures;
}
