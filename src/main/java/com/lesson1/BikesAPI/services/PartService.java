package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.model.APIExceptions.NotFoundException;
import com.lesson1.BikesAPI.model.Part;
import com.lesson1.BikesAPI.repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
    public void saveAllParts(List<Part> parts){
        partRepository.saveAll(parts);
    }
    public Part getPartById(Long id){
        return partRepository.findById(id).orElseThrow(
                ()->new NotFoundException("The part with the id " + id + " does not exist"));
    }
    public void deletePartById(Long id){
        partRepository.deleteById(id);
    }
}
