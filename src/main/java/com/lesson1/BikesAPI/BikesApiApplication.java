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
				new MotorBike("Honda", "CBR1000RR", "1000cc", "Red", 15000),
				new MotorBike("Yamaha", "R1", "1200cc", "Blue", 16000),
				new MotorBike("Suzuki", "GSX-R1000", "1300cc", "Black", 14000),
				new MotorBike("Kawasaki", "Ninja ZX-10R", "1500cc", "Green", 13000),
				new MotorBike("Ducati", "Panigale V4", "1400cc", "White", 17000)
		));
	}

}
