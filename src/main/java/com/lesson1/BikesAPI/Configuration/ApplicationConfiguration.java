package com.lesson1.BikesAPI.Configuration;

import com.lesson1.BikesAPI.model.Engine;
import com.lesson1.BikesAPI.model.MotorBike;
import com.lesson1.BikesAPI.model.Part;
import com.lesson1.BikesAPI.model.Wheel;
import com.lesson1.BikesAPI.repository.MotorBikesRepository;
import com.lesson1.BikesAPI.services.PartService;
import com.lesson1.BikesAPI.services.WheelService;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConfiguration implements ApplicationRunner {
    private final MotorBikesRepository motorBikesRepository;
    private final WheelService wheelService;
    private final PartService partService;


    public ApplicationConfiguration(MotorBikesRepository motorBikesRepository, WheelService wheelService, PartService partService) {
        this.motorBikesRepository = motorBikesRepository;
        this.wheelService = wheelService;
        this.partService = partService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        wheelService.SaveAllWheels(new ArrayList<>(List.of(
                new Wheel("Michelin", "Pilot Road 4", 120),
                new Wheel("Bridgestone", "Battlax S22", 110),
                new Wheel("Pirelli", "Diablo Rosso Corsa II", 250),
                new Wheel("Metzeler", "Roadtec 01", 130)
        )));
        List<Wheel> bike1Wheels = new ArrayList<>(List.of(
                wheelService.getWheelById(1L),
                wheelService.getWheelById(2L)
        ));
        List<Wheel> bike2Wheels = new ArrayList<>(List.of(
                wheelService.getWheelById(3L),
                wheelService.getWheelById(4L)
        ));
        partService.saveAllParts(new ArrayList<>(List.of(
                new Part("Brake", "Brembo", "Brembo 19RCS Corsa Corta", 500),
                new Part("Frame", "Aluminum Alloy", "Sportbike", 2500),
                new Part("Exhaust", "Akrapovic", "Racing Line", 1500),
                new Part("Suspension", "Öhlins", "STX 46", 1000)

        )));
//        List<Wheel> bike3Wheels = new ArrayList<>(List.of(
//                wheelService.getWheelById(1L),
//                wheelService.getWheelById(3L)
//        ));
//        List<Wheel> bike4Wheels = new ArrayList<>(List.of(
//                wheelService.getWheelById(2L),
//                wheelService.getWheelById(4L)
//        ));

        motorBikesRepository.saveAll(new ArrayList<MotorBike>(List.of(
                new MotorBike("Honda", "CBR1000RR", new Engine("v4", 1100), "Red", 15000),
                new MotorBike("Yamaha", "YZF-R1", new Engine("v2", 1200), "Blue", 14000),
                new MotorBike("Suzuki", "GSX-R1000", new Engine("v3", 1200), "Black", 13000),
                new MotorBike("Kawasaki", "Ninja ZX-10R", new Engine("FIv3", 1200), "Green", 12000),
                new MotorBike("Ducati", "Panigale V4", new Engine("v4.3", 1100), "Red", 15000),
                new MotorBike("Aprilia", "RSV4", new Engine("v4.0", 1100), "Black", 15000)
        )));

        motorBikesRepository.findById(1L).ifPresent(bike -> {
            bike.setWheels(bike1Wheels);
            bike.setParts(new ArrayList<>(List.of(
                    partService.getPartById(1L),
                    partService.getPartById(2L),
                    partService.getPartById(3L),
                    partService.getPartById(4L)
            )));
            motorBikesRepository.save(bike);
        });
        motorBikesRepository.findById(2L).ifPresent(bike -> {
            bike.setWheels(bike2Wheels);
            bike.setParts(new ArrayList<>(List.of(
                    partService.getPartById(1L),
                    partService.getPartById(2L),
                    partService.getPartById(3L),
                    partService.getPartById(4L)
            )));
            motorBikesRepository.save(bike);
        });
//        motorBikesRepository.findById(3L).ifPresent(bike -> {
//            bike.setWheels(bike3Wheels);
//            motorBikesRepository.save(bike);
//        });
//        motorBikesRepository.findById(4L).ifPresent(bike -> {
//            bike.setWheels(bike4Wheels);
//            motorBikesRepository.save(bike);
//        });
    }
}
