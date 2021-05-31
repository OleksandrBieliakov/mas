package com.obieliakov.mas.mp5.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Event> organizedEvents;

    @ManyToMany(mappedBy = "participants", cascade = CascadeType.REMOVE)
    private Set<Event> events;
}
