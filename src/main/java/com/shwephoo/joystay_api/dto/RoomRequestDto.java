package com.shwephoo.joystay_api.dto;

import com.shwephoo.joystay_api.enums.RoomStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomRequestDto {
    private String roomCode;
    private int floor;
    private RoomStatus status;
    private Long roomTypeId;
}
