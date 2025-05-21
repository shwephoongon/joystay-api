package com.shwephoo.joystay_api.exception;

public class ResourceExistsException extends RuntimeException {
    private final String details;
    public ResourceExistsException(String message, String details){
        super(message);
        this.details = details;
    }
    public String getDetails() {
        return details;
    }
}
