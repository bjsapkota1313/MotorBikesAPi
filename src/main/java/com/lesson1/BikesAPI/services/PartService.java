package com.lesson1.BikesAPI.services;

import com.lesson1.BikesAPI.repository.PartRepository;

public class PartService {
    private PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
}
