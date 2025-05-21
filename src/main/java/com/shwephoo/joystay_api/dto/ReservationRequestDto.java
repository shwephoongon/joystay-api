package com.shwephoo.joystay_api.dto;

import com.shwephoo.joystay_api.entity.Guest;
import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.enums.ReservationStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

    LocalDateTime checkin;
    int duration;
    LocalDateTime checkout;
    Long roomTypeId;
    int numberOfGuests;
    ReservationStatus status;
    GuestDetails guestDetails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GuestDetails {
        String name;
        String email;
        String phoneNumber;
        String address;
        String country;
    }
}
