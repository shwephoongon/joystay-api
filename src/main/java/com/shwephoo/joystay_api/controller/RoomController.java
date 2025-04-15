package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.dto.RoomRequestDto;
import com.shwephoo.joystay_api.dto.RoomResponseDto;
import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.service.RoomService;
import com.shwephoo.joystay_api.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomResponseDto> addRoomType(@RequestBody RoomRequestDto roomRequestDto) {
        RoomResponseDto addedRoom = roomService.addRoom(roomRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRoom);
    }
}
