package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "medicine")
@Getter
@Setter
public class Medicine {

    private static final int TITLE_MAX_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "cost")
    private BigDecimal cost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicine_type_id", foreignKey = @ForeignKey(name = "fk_medicine_type"))
    private MedicineType medicineType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", foreignKey = @ForeignKey(name = "fk_medicine_treatment"))
    private Treatment treatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id", foreignKey = @ForeignKey(name = "fk_medicine_procedure"))
    private Procedure procedure;
}
