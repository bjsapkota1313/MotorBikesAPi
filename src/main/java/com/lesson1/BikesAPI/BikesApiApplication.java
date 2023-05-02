package com.lesson1.BikesAPI;

import com.lesson1.BikesAPI.model.MotorBike;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BikesApiApplication {

    public static void main(String[] args) {
		try{
			SpringApplication.run(BikesApiApplication.class, args);
		} catch (Exception e) {
			System.out.println("Error starting Bikes API");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
    }
}
