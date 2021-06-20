package com.obieliakov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "medical_staff")
@Getter
@Setter
public abstract class MedicalStaff extends Person {

    @Column(name = "hourly_rate", nullable = false)
    private BigDecimal hourlyRate;
}
