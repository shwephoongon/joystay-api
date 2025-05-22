package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.dto.DefaultResponseDto;
import com.shwephoo.joystay_api.entity.Hotel;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RoomTypeController {
  //  private final RoomTypeService roomTypeService;

    @Autowired
    private RoomTypeService roomTypeService;
//    public RoomTypeController (RoomTypeService roomTypeService){
//        this.roomTypeService = roomTypeService;
//    }
    @PostMapping("/room-types")
    public ResponseEntity<RoomType> addRoomType(@RequestBody RoomType roomType) {
        RoomType addedRoomType = roomTypeService.addRoomType(roomType);
        return ResponseEntity.ok(addedRoomType);
    }
    @GetMapping("/room-types")
    public ResponseEntity<List<RoomType>> getRoomTypeList (){
        List<RoomType> roomTypeList = roomTypeService.getRoomTypeList();
        return ResponseEntity.ok(roomTypeList);
    }

    @PutMapping("/room-types/{id}")
    public ResponseEntity<DefaultResponseDto<RoomType>> updateRoomType(@PathVariable Long id, @RequestBody RoomType roomType) {
        RoomType updatedRoomType = roomTypeService.updateRoomType(id, roomType);
        DefaultResponseDto<RoomType> response = new DefaultResponseDto<>("success", updatedRoomType);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/room-types/{id}")
    public ResponseEntity<?> deleteRoomType (@PathVariable ("id") Long id){
        roomTypeService.deleteRoomType(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "successfully deleted room type at id " + id);
        return ResponseEntity.ok(response);
    }
}
