package com.obieliakov.clinic.repository;

import com.obieliakov.clinic.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
