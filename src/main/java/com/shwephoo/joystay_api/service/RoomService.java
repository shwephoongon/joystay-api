package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.dto.ResponseWithPageDto;
import com.shwephoo.joystay_api.dto.RoomRequestDto;
import com.shwephoo.joystay_api.dto.RoomResponseDto;
import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.enums.RoomStatus;
import com.shwephoo.joystay_api.exception.ResourceExistsException;
import com.shwephoo.joystay_api.exception.ResourceNotFoundException;
import com.shwephoo.joystay_api.repository.RoomRepository;
import com.shwephoo.joystay_api.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomTypeRepository roomTypeRepository;


    public RoomResponseDto addRoom(RoomRequestDto roomRequestDto) {
        Long requestRoomTypeId = roomRequestDto.getRoomTypeId();

        RoomType roomType = roomTypeRepository.findById(requestRoomTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("RoomType not found with id: " + requestRoomTypeId, "yes"));
        Optional<Room> roomData = roomRepository.findByRoomCode(roomRequestDto.getRoomCode());
        if (roomData.isPresent()) {
            throw new ResourceExistsException("Room Number already exists", roomData.get().getRoomCode() + " already exist");
        }

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
        responseDto.setRoomTypeId(room.getRoomType().getId());

        return responseDto;
    }

    public ResponseWithPageDto<Room> getAllRooms(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Room> roomsPage = roomRepository.findAll(pageable);
        ResponseWithPageDto.Pagination pagination = new ResponseWithPageDto.Pagination(
                roomsPage.getNumber(),
                roomsPage.getSize(),
                roomsPage.getTotalElements(),
                roomsPage.getTotalPages()
        );
        return new ResponseWithPageDto<>("success", pagination, roomsPage.getContent());
    }
}
