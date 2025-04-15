package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
