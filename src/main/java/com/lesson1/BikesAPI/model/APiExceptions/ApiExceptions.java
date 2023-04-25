package com.lesson1.BikesAPI.model.APiExceptions;

import lombok.Getter;

@Getter
public abstract class ApiExceptions  extends  RuntimeException{
    private final int  statusCode;

    protected ApiExceptions(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
