package com.shwephoo.joystay_api.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String message;
    private String details;

}
