package com.shwephoo.joystay_api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomStatus {
    AVAILABLE("Available"),
    OCCUPIED("Occupied"),
    RESERVED("Reserved"),
    OUT_OF_SERVICE("Out of Service");

    RoomStatus(String displayName) {
        this.displayName = displayName;
    }

    private final String displayName;

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static RoomStatus fromDisplayName(String value) {
        for (RoomStatus status : RoomStatus.values()) {
            if (status.displayName.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid RoomStatus: " + value);
    }



}
