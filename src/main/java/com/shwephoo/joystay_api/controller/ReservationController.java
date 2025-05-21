package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.dto.DefaultResponseDto;
import com.shwephoo.joystay_api.dto.ReservationRequestDto;
import com.shwephoo.joystay_api.dto.RoomRequestDto;
import com.shwephoo.joystay_api.dto.RoomResponseDto;
import com.shwephoo.joystay_api.entity.Reservation;
import com.shwephoo.joystay_api.service.ReservationService;
import com.shwephoo.joystay_api.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations")
    public ResponseEntity<DefaultResponseDto<Reservation>> addReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        Reservation addedReservation = reservationService.addReservation(reservationRequestDto);
        DefaultResponseDto<Reservation> response = new DefaultResponseDto<>("success", addedReservation);
        return ResponseEntity.ok(response);
    }
}
