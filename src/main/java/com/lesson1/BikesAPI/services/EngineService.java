package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.APIExceptions.NotFoundException;
import com.lesson1.BikesAPI.model.Engine;
import com.lesson1.BikesAPI.repository.EngineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {
    private final EngineRepository engineRepository;

    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }
    public void saveAllEngines( List<Engine> engines) {
        engineRepository.saveAll(engines);
    }
    public Engine getEngineById(Long id) {
        return engineRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The engine with the id " + id + " does not exist"));
    }
}
