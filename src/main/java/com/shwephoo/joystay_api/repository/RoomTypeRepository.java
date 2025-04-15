package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Hotel;
import com.shwephoo.joystay_api.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository  extends JpaRepository<RoomType, Long> {

}
