package com.shwephoo.joystay_api.entity;

import com.shwephoo.joystay_api.enums.RoomStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomCode;
    private int floor;
    @Enumerated(EnumType.STRING) // or EnumType.ORDINAL if you prefer numbers
    private RoomStatus status;

    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;
}
