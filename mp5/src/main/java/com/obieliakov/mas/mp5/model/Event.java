package com.obieliakov.mas.mp5.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    private ZonedDateTime startAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organizer_id", foreignKey = @ForeignKey(name = "fk_event_organizer"))
    private Participant organizer;

    @ManyToMany
    @JoinTable(
            joinColumns = {@JoinColumn(name = "event_id", foreignKey = @ForeignKey(name = "fk_event_participant"))},
            inverseJoinColumns = {@JoinColumn(name = "participant_id", foreignKey = @ForeignKey(name = "fk_participant_event"))})
    private Set<Participant> participants;
}
