package com.shwephoo.joystay_api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReservationStatus {
    CONFIRMED("confirmed"),
    CHECKED_IN("checked_in"),
    CHECKED_OUT("checked_out"),
    CANCELLED("cancelled");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ReservationStatus fromValue(String value) {
        for (ReservationStatus status : ReservationStatus.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown reservation status: " + value);
    }

    }
