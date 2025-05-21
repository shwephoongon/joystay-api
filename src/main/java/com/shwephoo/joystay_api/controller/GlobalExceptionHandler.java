package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.exception.ResourceNotFoundException;
import com.shwephoo.joystay_api.exception.ResourceExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.shwephoo.joystay_api.entity.ErrorResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleRoomTypeNotFoundException(ResourceNotFoundException exception) {
        ErrorResponse roomTypeNotFound = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "Room type not found");

        return new ResponseEntity<>(roomTypeNotFound, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<?> handleResourceExistsException(ResourceExistsException exception) {
        ErrorResponse roomExists = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), exception.getDetails());

        return new ResponseEntity<>(roomExists, HttpStatus.CONFLICT);
    }
}
