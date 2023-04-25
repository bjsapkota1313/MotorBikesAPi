package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.APiExceptions.ConflictException;
import com.lesson1.BikesAPI.model.APiExceptions.NotFoundException;
import com.lesson1.BikesAPI.model.MotorBike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorBikesService {
    private List<MotorBike> bikes;

    public MotorBikesService(List<MotorBike> bikes) {
        this.bikes = bikes;
    }

    public List<MotorBike> getAllBikes() {
        return bikes;
    }

    public MotorBike getBikeById(long id) {
        return bikes.stream().filter(bike -> bike.getId() == id)
                .findFirst().
                orElse(null);
    }

    public MotorBike addBike(MotorBike bike) throws ConflictException {
        if (bikes.contains(bike)) {
            throw new ConflictException("Bike already exists");
        }
        bikes.add(bike);
        return getBikeById(bike.getId());
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
        MotorBike bikeToDelete = getBikeById(id);
        if (bikeToDelete == null) {
            throw new NotFoundException("The bike with the id " + id + " which you are trying to Delete does not exist");
        }
        bikes.remove(bikeToDelete);
    }

}
