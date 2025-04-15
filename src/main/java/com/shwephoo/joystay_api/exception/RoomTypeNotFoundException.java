package com.shwephoo.joystay_api.exception;

public class RoomTypeNotFoundException extends RuntimeException{
    public RoomTypeNotFoundException(String message){
        super(message);
    }
}
