package com.lesson1.BikesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikesApiApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(BikesApiApplication.class, args);
        } catch (Exception e) {
            System.out.println("Error starting Bikes API");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}
