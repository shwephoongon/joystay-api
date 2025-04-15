package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.exception.RoomTypeNotFoundException;
import com.shwephoo.joystay_api.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    RoomTypeRepository roomTypeRepository;

    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public List<RoomType> getRoomTypeList() {
        return roomTypeRepository.findAll();
    }

    public RoomType updateRoomType(Long id, RoomType roomType) {
        RoomType existingRoomType = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RoomTypeNotFoundException("RoomType not found with id: " + id));

        existingRoomType.setName(roomType.getName());
        existingRoomType.setPricePerNight(roomType.getPricePerNight());

        return roomTypeRepository.save(existingRoomType);
    }


    public void deleteRoomType (Long id){
        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RoomTypeNotFoundException("RoomType not found with id: " + id));
        roomTypeRepository.delete(roomType);
    }
}


