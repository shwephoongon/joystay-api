package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.dto.DefaultResponseDto;
import com.shwephoo.joystay_api.dto.ResponseWithPageDto;
import com.shwephoo.joystay_api.dto.RoomRequestDto;
import com.shwephoo.joystay_api.dto.RoomResponseDto;
import com.shwephoo.joystay_api.entity.Room;
import com.shwephoo.joystay_api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<DefaultResponseDto<RoomResponseDto>> addRoomType(@RequestBody RoomRequestDto roomRequestDto) {
        RoomResponseDto addedRoom = roomService.addRoom(roomRequestDto);
        DefaultResponseDto<RoomResponseDto> response = new DefaultResponseDto<>("success", addedRoom);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms")
    public ResponseWithPageDto<Room> getAllRooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return roomService.getAllRooms(page, size, sortBy);
    }
}
