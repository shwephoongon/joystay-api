package com.shwephoo.joystay_api.mapper;

import com.shwephoo.joystay_api.dto.ReservationRequestDto;
import com.shwephoo.joystay_api.entity.Guest;
import com.shwephoo.joystay_api.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppMapper {
    Guest guestDetailsToGuest(ReservationRequestDto.GuestDetails dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType", ignore = true)
    @Mapping(target = "guestDetails", ignore = true)
    Reservation reservationRequestToReservation(ReservationRequestDto dto);

}
