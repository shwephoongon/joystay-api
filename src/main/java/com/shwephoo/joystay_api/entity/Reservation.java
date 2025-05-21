package com.shwephoo.joystay_api.entity;

import com.shwephoo.joystay_api.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime checkin;
    int duration;
    LocalDateTime checkout;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    RoomType roomType;
    int numberOfGuests;
    ReservationStatus status;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    Guest guestDetails;
}
