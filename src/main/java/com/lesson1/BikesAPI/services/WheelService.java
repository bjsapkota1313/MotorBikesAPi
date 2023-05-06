package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.APIExceptions.NotFoundException;
import com.lesson1.BikesAPI.model.Wheel;
import com.lesson1.BikesAPI.repository.WheelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WheelService {
    private WheelRepository wheelRepository;

    public WheelService(WheelRepository wheelRepository) {
        this.wheelRepository = wheelRepository;
    }

    public Wheel getWheelById(Long id) {
        return wheelRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The wheel with the id " + id + " does not exist"));
    }

    public List<Wheel> SaveAllWheels(List<Wheel> wheels) {
        return (List<Wheel>) wheelRepository.saveAll(wheels);
    }
}
