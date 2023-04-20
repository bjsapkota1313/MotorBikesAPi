package com.lesson1.BikesAPI.Controllers;

import com.lesson1.BikesAPI.model.APiExceptions.*;
import com.lesson1.BikesAPI.model.MotorBike;
import com.lesson1.BikesAPI.services.MotorBikesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/motorbikes", produces = MediaType.APPLICATION_JSON_VALUE)
public class MotorBikeController {
    private final MotorBikesService motorBikesService;

    public MotorBikeController(MotorBikesService motorBikesService) {
        this.motorBikesService = motorBikesService;
    }

    @GetMapping
    public ResponseEntity getAllBikes() {
        return ResponseEntity.ok(motorBikesService.getAllBikes());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBikeById(@PathVariable int id) {
        try {
            MotorBike bike = motorBikesService.getBikeById(id);
            if (bike == null) {
                throw new NotFoundException("The bike with the id " + id + " does not exist");
            }
            return ResponseEntity.ok(motorBikesService.getBikeById(id));
        } catch (ApiExceptions e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity addBike(@RequestBody MotorBike bike) {
        try {
            MotorBike newBike = motorBikesService.addBike(bike);
            return ResponseEntity.status(201).body(newBike);
        } catch (ApiExceptions e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBike(@PathVariable int id, @RequestBody MotorBike bike) {
        try {
            if (id == 0) {
                throw new BadRequestException("The id of the bike cannot be 0");
            }
            if (bike == null) {
                throw new BadRequestException("The Body of the request cannot be left empty");
            }
            return ResponseEntity.ok(motorBikesService.updateBike(bike, id));
        } catch (ApiExceptions e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBike(@PathVariable int id) {
        try {
            if (id == 0) {
                throw new BadRequestException("The Whole Resource cannot be deleted  id must be provided");
            }
            motorBikesService.deleteBike(id);
            return ResponseEntity.status(204).build();
        } catch (ApiExceptions e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
        }

    }


}
