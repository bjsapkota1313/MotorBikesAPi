package com.lesson1.BikesAPI.model.APIExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

@Getter
public abstract class ApiExceptions extends ResponseStatusException {

    protected ApiExceptions(int status, String message) {
        super(HttpStatusCode.valueOf(status), message);
    }
}
