package com.obieliakov.mas.mp5.repository;

import com.obieliakov.mas.mp5.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByTitle(String title);

    @Query("select p.events from Participant p where p.name = :participantName")
    List<Event> queryAllEventsByParticipantName(@Param("participantName") String participantName);

    @Query("select p.organizedEvents from Participant p where p.name = :participantName")
    List<Event> queryAllOrganizedEventsByParticipantName(@Param("participantName") String participantName);
}
