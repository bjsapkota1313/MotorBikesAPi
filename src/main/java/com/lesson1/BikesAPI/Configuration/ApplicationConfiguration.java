package com.lesson1.BikesAPI.Configuration;

import com.lesson1.BikesAPI.model.Engine;
import com.lesson1.BikesAPI.model.MotorBike;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.lesson1.BikesAPI.repository.MotorBikesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ApplicationConfiguration implements ApplicationRunner {
    private final MotorBikesRepository motorBikesRepository;


    public ApplicationConfiguration(MotorBikesRepository motorBikesRepository) {
        this.motorBikesRepository = motorBikesRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        motorBikesRepository.saveAll(new ArrayList<>(List.of(
                new MotorBike("Honda", "CBR1000RR", new Engine("v4",1100), "Red", 15000),
                new MotorBike("Yamaha", "YZF-R1", new Engine("v2",1200), "Blue", 14000),
                new MotorBike("Suzuki", "GSX-R1000", new Engine("v3",1200), "Black", 13000),
                new MotorBike("Kawasaki", "Ninja ZX-10R", new Engine("v3",1200), "Green", 12000),
                new MotorBike("Ducati", "Panigale V4", new Engine("v4",1100), "Red", 15000),
                new MotorBike("Aprilia", "RSV4", new Engine("v4",1100), "Black", 15000)
        )));
    }
}
