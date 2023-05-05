package com.lesson1.BikesAPI.Configuration;


import com.lesson1.BikesAPI.model.APIExceptions.ApiExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionsHandler {

    @ExceptionHandler(ApiExceptions.class)
    public ResponseEntity handleApiExceptions(ApiExceptions e) {
        System.out.println("ApiExceptions: " + e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
    }
}
