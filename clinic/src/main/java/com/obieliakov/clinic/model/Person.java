package com.obieliakov.clinic.model;

import com.obieliakov.clinic.model.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class Person {

    public static final int NAME_MAX_LENGTH = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = NAME_MAX_LENGTH)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = NAME_MAX_LENGTH)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private ZonedDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false, length = Sex.MAX_LENGTH)
    private Sex sex;
}
