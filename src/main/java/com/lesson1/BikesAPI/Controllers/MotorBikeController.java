package com.lesson1.BikesAPI.Controllers;

import com.lesson1.BikesAPI.model.APIExceptions.BadRequestException;
import com.lesson1.BikesAPI.model.APIExceptions.NotFoundException;
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
        MotorBike bike = motorBikesService.getBikeById(id);
        if (bike == null) {
            throw new NotFoundException("The bike with the id " + id + " does not exist");
        }
        return ResponseEntity.ok(motorBikesService.getBikeById(id));
    }

    @PostMapping
    public ResponseEntity addBike(@RequestBody MotorBike bike) {
        MotorBike newBike = motorBikesService.addBike(bike);
        return ResponseEntity.status(201).body(newBike);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBike(@PathVariable long id, @RequestBody MotorBike bike) {
        if (id == 0) {
            throw new BadRequestException("The id of the bike cannot be 0");
        }
        if (bike == null) {
            throw new BadRequestException("The Body of the request cannot be left empty");
        }
        return ResponseEntity.ok(motorBikesService.updateBike(bike, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBike(@PathVariable long id) {
        if (id == 0) {
            throw new BadRequestException("The Whole Resource cannot be deleted  id must be provided");
        }
        motorBikesService.deleteBike(id);
        return ResponseEntity.status(204).build();
    }


}
