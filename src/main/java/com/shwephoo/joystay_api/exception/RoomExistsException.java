package com.shwephoo.joystay_api.exception;

public class RoomExistsException extends RuntimeException {
    public RoomExistsException(String message){
        super(message);
    }
}
