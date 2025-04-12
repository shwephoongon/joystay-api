package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface HotelRepository extends JpaRepository <Hotel, Long> {
    public Hotel findHotelByName (String name);
    public Hotel findHotelById (Long id);
}
