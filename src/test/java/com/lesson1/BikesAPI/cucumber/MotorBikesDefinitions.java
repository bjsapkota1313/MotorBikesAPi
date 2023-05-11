package com.lesson1.BikesAPI.cucumber;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class MotorBikesDefinitions extends MyStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Given("the endpoint is called with a GET request")
    public void theEndpointIsCalledWithAGETRequest() {

    }

}
