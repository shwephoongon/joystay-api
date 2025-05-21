package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.dto.ReservationRequestDto;
import com.shwephoo.joystay_api.entity.Guest;
import com.shwephoo.joystay_api.entity.Reservation;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.exception.ResourceNotFoundException;
import com.shwephoo.joystay_api.repository.GuestRepository;
import com.shwephoo.joystay_api.repository.ReservationRepository;
import com.shwephoo.joystay_api.repository.RoomTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomTypeRepository roomTypeRepository;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomTypeRepository roomTypeRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public Guest mapDtoToEntity(ReservationRequestDto.GuestDetails dto) {
        Guest guest = new Guest();
        guest.setName(dto.getName());
        guest.setEmail(dto.getEmail());
        guest.setPhoneNumber(dto.getPhoneNumber());
        guest.setAddress(dto.getAddress());
        guest.setCountry(dto.getCountry());
        return guest;
    }
    @Transactional
    public Reservation addReservation(ReservationRequestDto reservationRequestDto) {
        Guest guestEntity = mapDtoToEntity(reservationRequestDto.getGuestDetails());
        Guest savedGuest = guestRepository.save(guestEntity);

        RoomType roomType = roomTypeRepository.findById(reservationRequestDto.getRoomTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Room type not found","description"));

        Reservation reservation = new Reservation();
        reservation.setDuration(reservationRequestDto.getDuration());
        reservation.setCheckin(reservationRequestDto.getCheckin());
        reservation.setCheckout(reservationRequestDto.getCheckout());
        reservation.setStatus(reservationRequestDto.getStatus());
        reservation.setRoomType(roomType);
        reservation.setNumberOfGuests(reservationRequestDto.getNumberOfGuests());
        reservation.setGuestDetails(savedGuest);
        return reservationRepository.save(reservation);
    }
}
