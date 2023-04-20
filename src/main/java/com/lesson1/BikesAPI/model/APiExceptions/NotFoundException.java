package com.lesson1.BikesAPI.model.APiExceptions;

public class NotFoundException extends ApiExceptions {

    public NotFoundException(String body) {
        super(404, body); // 404 is the status code for not found
    }

    public NotFoundException() {
        super(404, "Not found");
    }
}

