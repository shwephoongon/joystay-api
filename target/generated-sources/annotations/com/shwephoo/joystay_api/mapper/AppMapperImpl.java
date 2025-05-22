package com.shwephoo.joystay_api.mapper;

import com.shwephoo.joystay_api.dto.ReservationRequestDto;
import com.shwephoo.joystay_api.entity.Guest;
import com.shwephoo.joystay_api.entity.Reservation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T11:53:35+0630",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.10 (Microsoft)"
)
@Component
public class AppMapperImpl implements AppMapper {

    @Override
    public Guest guestDetailsToGuest(ReservationRequestDto.GuestDetails dto) {
        if ( dto == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setName( dto.getName() );
        guest.setEmail( dto.getEmail() );
        guest.setPhoneNumber( dto.getPhoneNumber() );
        guest.setAddress( dto.getAddress() );
        guest.setCountry( dto.getCountry() );

        return guest;
    }

    @Override
    public Reservation reservationRequestToReservation(ReservationRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setCheckin( dto.getCheckin() );
        reservation.setDuration( dto.getDuration() );
        reservation.setCheckout( dto.getCheckout() );
        reservation.setNumberOfGuests( dto.getNumberOfGuests() );
        reservation.setStatus( dto.getStatus() );

        return reservation;
    }
}
