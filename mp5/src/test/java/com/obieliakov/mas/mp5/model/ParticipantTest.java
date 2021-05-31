package com.obieliakov.mas.mp5.model;

import com.obieliakov.mas.mp5.repository.EventRepository;
import com.obieliakov.mas.mp5.repository.ParticipantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ParticipantTest {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void testDependencies() {
        assertNotNull(participantRepository);
        assertNotNull(eventRepository);
    }

    @Test
    void testLoadedParticipants() {
        assertEquals(4, participantRepository.findAll().size());

        assertEquals(1, participantRepository.findAllByName("p1").size());
        assertEquals(1, participantRepository.findAllByName("p2").size());
        assertEquals(1, participantRepository.findAllByName("p3").size());
        assertEquals(1, participantRepository.findAllByName("p4").size());
        assertEquals(0, participantRepository.findAllByName("p5").size());
    }

    @Test
    void testParticipantEvents() {
        assertEquals(1, eventRepository.queryAllEventsByParticipantName("p1").size());
        assertEquals(2, eventRepository.queryAllEventsByParticipantName("p2").size());
        assertEquals(1, eventRepository.queryAllEventsByParticipantName("p3").size());
        assertEquals(0, eventRepository.queryAllEventsByParticipantName("p4").size());
    }

    @Test
    void testParticipantOrganizedEvents() {
        assertEquals(2, eventRepository.queryAllOrganizedEventsByParticipantName("p1").size());
        assertEquals(1, eventRepository.queryAllOrganizedEventsByParticipantName("p2").size());
        assertEquals(1, eventRepository.queryAllOrganizedEventsByParticipantName("p3").size());
        assertEquals(0, eventRepository.queryAllOrganizedEventsByParticipantName("p4").size());
    }
}