package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.entity.Hotel;
import com.shwephoo.joystay_api.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel addHotel = hotelService.addHotel(hotel);
        return ResponseEntity.ok(addHotel);
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") Long id) {
        Hotel foundHotel = hotelService.findHotelById(id);
        return ResponseEntity.ok(foundHotel);
    }

    @PutMapping("/updateHotel")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        Hotel updateHotel = hotelService.updateHotel(hotel);
        return ResponseEntity.ok(updateHotel);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<Hotel> deleteHotel (@PathVariable ("id") Long id){
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }
}
