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
	@Bean
	public List<MotorBike> bikes(){
		return new ArrayList<>(List.of(
				new MotorBike(1,"Honda", "CBR1000RR", "1000cc", "Red", 15000),
				new MotorBike(2,"Yamaha", "R1", "1000cc", "Blue", 16000),
				new MotorBike(3,"Suzuki", "GSX-R1000", "1000cc", "Black", 14000),
				new MotorBike(4,"Kawasaki", "Ninja ZX-10R", "1000cc", "Green", 13000),
				new MotorBike(5,"Ducati", "Panigale V4", "1000cc", "White", 17000)
		));
	}

}
