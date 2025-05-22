package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.dto.ReservationRequestDto;
import com.shwephoo.joystay_api.entity.Guest;
import com.shwephoo.joystay_api.entity.Reservation;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.exception.ResourceNotFoundException;
import com.shwephoo.joystay_api.mapper.AppMapper;
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
    private final AppMapper appMapper;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, RoomTypeRepository roomTypeRepository, AppMapper appMapper) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.appMapper = appMapper;
    }

    public Reservation addReservation(ReservationRequestDto dto) {

        Guest guestEntity = appMapper.guestDetailsToGuest(dto.getGuestDetails());
        Guest savedGuest = guestRepository.save(guestEntity);
        Reservation reservation = appMapper.reservationRequestToReservation(dto);
        RoomType roomType = roomTypeRepository.findById(dto.getRoomTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Room type not found", "description"));
        reservation.setGuestDetails(savedGuest);
        reservation.setRoomType(roomType);
        return reservationRepository.save(reservation);
    }
}
