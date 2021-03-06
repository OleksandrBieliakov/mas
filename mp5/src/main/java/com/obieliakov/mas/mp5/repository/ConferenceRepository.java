package com.obieliakov.mas.mp5.repository;

import com.obieliakov.mas.mp5.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    List<Conference> findAllByTitle(String title);

    List<Conference> findByTopics(String topic);

    @Query("select c from Conference c join c.topics t where t = :topic ")
    List<Conference> queryAllByTopic(@Param("topic") String topic);
}
