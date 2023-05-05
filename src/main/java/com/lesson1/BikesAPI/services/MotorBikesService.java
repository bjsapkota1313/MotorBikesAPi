package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.APIExceptions.ConflictException;
import com.lesson1.BikesAPI.model.APIExceptions.NotFoundException;
import com.lesson1.BikesAPI.model.DTO.MotorBikeDTO;
import com.lesson1.BikesAPI.model.Engine;
import com.lesson1.BikesAPI.model.MotorBike;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.lesson1.BikesAPI.repository.MotorBikesRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MotorBikesService {
    private MotorBikesRepository motorBikesRepository;

    public MotorBikesService(MotorBikesRepository motorBikesRepository) {
        this.motorBikesRepository = motorBikesRepository;
    }

    public List<MotorBike> getAllBikes() {

        return (List<MotorBike>) motorBikesRepository.findAll();
    }

    public MotorBike getBikeById(long id) {
        return motorBikesRepository.findById(id).orElseThrow(() -> new NotFoundException("The bike with the id " + id + " does not exist"));
    }

    public MotorBike addBike(MotorBikeDTO bike) throws ConflictException {
        if(motorBikesRepository.existsByBrandAndModel(bike.brand(), bike.model())) {
            throw new ConflictException("The bike with the brand " + bike.brand() + " and model " + bike.model() + " already exists");
        }
        return motorBikesRepository.save(new MotorBike(bike.brand(), bike.model(),
                new Engine(bike.engine().type(),bike.engine().volume()), bike.color(), bike.price()));
    }

    public MotorBike updateBike(MotorBike bike, long id)  {
        MotorBike bikeToUpdate = getBikeById(id);
        if (bikeToUpdate == null) {
            throw new NotFoundException("The bike you are trying to update does not exist");
        }
        bikeToUpdate.setBrand(bike.getBrand());
        bikeToUpdate.setModel(bike.getModel());
        bikeToUpdate.setEngine(bike.getEngine());
        bikeToUpdate.setColor(bike.getColor());
        bikeToUpdate.setPrice(bike.getPrice());
        return bikeToUpdate;
    }
    public void deleteBike(long id) {
        if(!motorBikesRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The bike with the id " + id + " does not exist");
        }
        motorBikesRepository.deleteById(id);
    }

}
