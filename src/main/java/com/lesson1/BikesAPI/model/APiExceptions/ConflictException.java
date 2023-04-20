package com.lesson1.BikesAPI.model.APiExceptions;

public class ConflictException extends ApiExceptions {
    public ConflictException(String body) {
        super(409, body);
    }
    public ConflictException() {
        super(409, "Conflict");
    }
}
