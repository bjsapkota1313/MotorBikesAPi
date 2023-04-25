package com.lesson1.BikesAPI;


import com.lesson1.BikesAPI.model.APiExceptions.ApiExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionsHandler {

    @ExceptionHandler(ApiExceptions.class)
    public ResponseEntity handleApiExceptions(ApiExceptions e) {
        return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
    }
}
