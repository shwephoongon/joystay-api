package com.shwephoo.joystay_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomRequestDto {
    private String roomCode;
    private int floor;
    private int status;
    private Long roomTypeId;
}
