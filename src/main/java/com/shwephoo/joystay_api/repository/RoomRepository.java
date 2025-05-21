package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.entity.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomCode(String roomCode);
    Page<Room> findAll(Pageable pageable);
}
