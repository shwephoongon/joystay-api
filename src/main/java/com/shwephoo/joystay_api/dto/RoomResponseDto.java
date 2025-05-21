package com.shwephoo.joystay_api.dto;

import com.shwephoo.joystay_api.entity.RoomType;
import com.shwephoo.joystay_api.enums.RoomStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomResponseDto {
        private Long id;
        private String roomCode;
        private int floor;
        private RoomStatus status;
        private Long roomTypeId;
}
