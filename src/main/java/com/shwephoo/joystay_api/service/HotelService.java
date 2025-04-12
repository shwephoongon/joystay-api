package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.entity.Hotel;
import com.shwephoo.joystay_api.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
      return hotelRepository.save(hotel);
    }

    public Hotel findHotelById(Long id){
        return hotelRepository.findHotelById(id);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel (Long id){
        hotelRepository.deleteById(id);
    }


}
