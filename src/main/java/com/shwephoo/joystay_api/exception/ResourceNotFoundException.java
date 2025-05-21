package com.shwephoo.joystay_api.exception;

public class ResourceNotFoundException extends RuntimeException{
    private final String description;
    public ResourceNotFoundException(String message, String description){
        super(message);
        this.description = description;
    }
    public String getDescription (){
        return description;
    }
}
