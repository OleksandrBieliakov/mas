package com.obieliakov.mas.mp5.repository;

import com.obieliakov.mas.mp5.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long> {

    List<Party> findAllByTitle(String title);

    List<Party> findByFood(String food);
}
