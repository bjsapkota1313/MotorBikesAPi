package com.lesson1.BikesAPI.Configuration;

import com.lesson1.BikesAPI.model.MotorBike;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import repository.MotorBikesRepository;

import java.util.List;

public class ApplicationConfiguration implements ApplicationRunner {
    private final MotorBikesRepository motorBikesRepository;
    private  List<MotorBike> bikes;

    public ApplicationConfiguration(MotorBikesRepository motorBikesRepository, List<MotorBike> bikes) {
        this.motorBikesRepository = motorBikesRepository;
        this.bikes = bikes;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

    }
}
