package com.obieliakov.mas.mp5.repository;

import com.obieliakov.mas.mp5.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    List<Participant> findAllByName(String name);

    @Query("select e.participants from Event e where e.title = :eventTitle")
    List<Participant> queryAllParticipantsByEventTitle(@Param("eventTitle") String eventTitle);

    @Query("select e.organizer from Event e where e.title = :eventTitle")
    Optional<Participant> queryOrganizerByEventTitle(@Param("eventTitle") String eventTitle);
}
