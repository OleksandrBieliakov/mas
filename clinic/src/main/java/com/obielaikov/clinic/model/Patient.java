package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient extends Person {

    @Column(name = "insurance_number")
    private Integer insuranceNumber;
}
