package com.obielaikov.clinic.repository;

import com.obielaikov.clinic.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
