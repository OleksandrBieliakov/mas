package com.obielaikov.clinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
    private static final int ROOM_NO_MAX_LENGTH = 50;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_no", nullable = false, length = ROOM_NO_MAX_LENGTH)
    private String roomNo;

    @OneToMany(mappedBy = "room")
    private Set<Appointment> appointments;
}
