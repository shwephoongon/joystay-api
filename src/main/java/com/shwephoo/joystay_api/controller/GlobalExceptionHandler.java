package com.shwephoo.joystay_api.controller;

import com.shwephoo.joystay_api.exception.RoomExistsException;
import com.shwephoo.joystay_api.exception.RoomTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.shwephoo.joystay_api.entity.ErrorResponse;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomTypeNotFoundException.class)
    public ResponseEntity<?> handleRoomTypeNotFoundException (RoomTypeNotFoundException exception){
        ErrorResponse roomTypeNotFound = new ErrorResponse(LocalDateTime.now(), exception.getMessage(),"Room type not found");

        return new ResponseEntity<>(roomTypeNotFound, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RoomExistsException.class)
    public ResponseEntity<?> handleRoomExistsException (RoomTypeNotFoundException exception){
        ErrorResponse roomExists = new ErrorResponse(LocalDateTime.now(), exception.getMessage(),"Room already existst");

        return new ResponseEntity<>(roomExists, HttpStatus.NOT_FOUND);
    }
}
