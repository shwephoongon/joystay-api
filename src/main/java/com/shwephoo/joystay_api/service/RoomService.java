package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.dto.RoomRequestDto;
import com.shwephoo.joystay_api.dto.RoomResponseDto;
import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.exception.RoomTypeNotFoundException;
import com.shwephoo.joystay_api.repository.RoomRepository;
import com.shwephoo.joystay_api.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomTypeRepository roomTypeRepository;


    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {
        Long requestRoomTypeId = roomRequestDto.getRoomTypeId();

        RoomType roomType = roomTypeRepository.findById(requestRoomTypeId)
                .orElseThrow(() -> new RoomTypeNotFoundException("RoomType not found with id: " + requestRoomTypeId));

        Room room = new Room();
        room.setRoomCode(roomRequestDto.getRoomCode());
        room.setStatus(roomRequestDto.getStatus());
        room.setFloor(roomRequestDto.getFloor());
        room.setRoomType(roomType);

        Room savedRoom = roomRepository.save(room);

        RoomResponseDto responseDto = new RoomResponseDto();
        responseDto.setId(savedRoom.getId());
        responseDto.setRoomCode(savedRoom.getRoomCode());
        responseDto.setFloor(savedRoom.getFloor());
        responseDto.setStatus(savedRoom.getStatus());
        responseDto.setRoomType(room.getRoomType());

        return responseDto;
    }
}
