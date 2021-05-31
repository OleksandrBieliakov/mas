package com.obieliakov.mas.mp5.model;

import com.obieliakov.mas.mp5.repository.ConferenceRepository;
import com.obieliakov.mas.mp5.repository.EventRepository;
import com.obieliakov.mas.mp5.repository.ParticipantRepository;
import com.obieliakov.mas.mp5.repository.PartyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventTest {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Test
    void testDependencies() {
        assertNotNull(eventRepository);
        assertNotNull(conferenceRepository);
        assertNotNull(partyRepository);
        assertNotNull(participantRepository);
    }

    @Test
    void testLoadedEvents() {
        assertEquals(2, conferenceRepository.findAll().size());
        assertEquals(2, partyRepository.findAll().size());
        assertEquals(4, eventRepository.findAll().size());

        assertEquals(1, eventRepository.findAllByTitle("c1").size());
        assertEquals(1, eventRepository.findAllByTitle("c2").size());
        assertEquals(0, eventRepository.findAllByTitle("c3").size());
        assertEquals(1, eventRepository.findAllByTitle("pa1").size());
        assertEquals(1, eventRepository.findAllByTitle("pa2").size());
        assertEquals(0, eventRepository.findAllByTitle("pa3").size());
    }

    @Test
    void testEventParticipants() {
        assertEquals(2, participantRepository.queryAllParticipantsByEventTitle("c1").size());
        assertEquals(0, participantRepository.queryAllParticipantsByEventTitle("c2").size());
        assertEquals(2, participantRepository.queryAllParticipantsByEventTitle("pa1").size());
        assertEquals(0, participantRepository.queryAllParticipantsByEventTitle("pa2").size());
        assertEquals(0, participantRepository.queryAllParticipantsByEventTitle("not existent").size());
    }

    @Test
    void testEventOrganizer() {
        assertEquals("p1", participantRepository.queryOrganizerByEventTitle("c1").get().getName());
        assertEquals("p1", participantRepository.queryOrganizerByEventTitle("c2").get().getName());
        assertEquals("p2", participantRepository.queryOrganizerByEventTitle("pa1").get().getName());
        assertEquals("p3", participantRepository.queryOrganizerByEventTitle("pa2").get().getName());
        assertTrue(participantRepository.queryOrganizerByEventTitle("not existent").isEmpty());
    }

    @Test
    @Transactional
    void partyTest() {
        assertEquals(1, partyRepository.findAllByTitle("pa1").size());
        assertEquals(1, partyRepository.findAllByTitle("pa2").size());
        assertEquals(0, partyRepository.findAllByTitle("pa3").size());

        assertTrue(partyRepository.findAllByTitle("pa1").get(0).getFood().contains("f1"));
        assertTrue(partyRepository.findAllByTitle("pa1").get(0).getFood().contains("f2"));
        assertTrue(partyRepository.findAllByTitle("pa2").get(0).getFood().contains("f1"));
        assertFalse(partyRepository.findAllByTitle("pa2").get(0).getFood().contains("f2"));

        assertEquals(2, partyRepository.findByFood("f1").size());
        assertEquals(1, partyRepository.findByFood("f2").size());
        assertEquals(0, partyRepository.findByFood("f3").size());
    }

    @Test
    @Transactional
    void conferenceTest() {
        assertEquals(1, conferenceRepository.findAllByTitle("c1").size());
        assertEquals(1, conferenceRepository.findAllByTitle("c2").size());
        assertEquals(0, conferenceRepository.findAllByTitle("c3").size());

        assertTrue(conferenceRepository.findAllByTitle("c1").get(0).getTopics().contains("t1"));
        assertTrue(conferenceRepository.findAllByTitle("c1").get(0).getTopics().contains("t2"));
        assertTrue(conferenceRepository.findAllByTitle("c2").get(0).getTopics().contains("t1"));
        assertFalse(conferenceRepository.findAllByTitle("c2").get(0).getTopics().contains("t2"));

        assertEquals(2, conferenceRepository.findByTopics("t1").size());
        assertEquals(1, conferenceRepository.findByTopics("t2").size());
        assertEquals(0, conferenceRepository.findByTopics("t3").size());

        //same but using query
        assertEquals(2, conferenceRepository.queryAllByTopic("t1").size());
        assertEquals(1, conferenceRepository.queryAllByTopic("t2").size());
        assertEquals(0, conferenceRepository.queryAllByTopic("t3").size());
    }
}