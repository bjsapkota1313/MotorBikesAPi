package com.lesson1.BikesAPI.model.APIExceptions;

public class
BadRequestException extends ApiExceptions {
    public BadRequestException(String body) {
        super(400, body); // 400 is the status code for bad request
    }

    public BadRequestException() {
        super(400, "Bad request");
    }
}

