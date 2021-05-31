package com.obieliakov.mas.mp5.repository;

import com.obieliakov.mas.mp5.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    List<Conference> findAllByTitle(String title);

    List<Conference> findByTopics(String topic);
}
