package com.obieliakov.mas.mp5;

import com.obieliakov.mas.mp5.model.Conference;
import com.obieliakov.mas.mp5.model.Participant;
import com.obieliakov.mas.mp5.model.Party;
import com.obieliakov.mas.mp5.repository.ConferenceRepository;
import com.obieliakov.mas.mp5.repository.ParticipantRepository;
import com.obieliakov.mas.mp5.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ParticipantRepository participantRepository;
    private final ConferenceRepository conferenceRepository;
    private final PartyRepository partyRepository;

    @Override
    public void run(String... args) throws Exception {
        Participant participant1 = Participant.builder().name("p1").build();
        Participant participant2 = Participant.builder().name("p2").build();
        Participant participant3 = Participant.builder().name("p3").build();
        Participant participant4 = Participant.builder().name("p4").build();
        participantRepository.saveAll(List.of(participant1, participant2, participant3, participant4));

        Conference conference1 = Conference.builder()
                .title("c1")
                .startAt(ZonedDateTime.now().plusWeeks(2))
                .organizer(participant1)
                .participants(Set.of(participant1, participant2))
                .topics(Set.of("t1", "t2"))
                .build();
        Conference conference2 = Conference.builder()
                .title("c2")
                .organizer(participant1)
                .topics(Set.of("t1"))
                .build();
        conferenceRepository.saveAll(List.of(conference1, conference2));

        Party party1 = Party.builder()
                .title("pa1")
                .startAt(ZonedDateTime.now().plusMonths(3))
                .organizer(participant2)
                .participants(Set.of(participant2, participant3))
                .food(Set.of("f1", "f2"))
                .build();
        Party party2 = Party.builder()
                .title("pa2")
                .organizer(participant3)
                .food(Set.of("f1"))
                .build();
        partyRepository.saveAll(Set.of(party1, party2));
    }
}
