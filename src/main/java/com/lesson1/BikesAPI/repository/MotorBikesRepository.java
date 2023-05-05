package com.lesson1.BikesAPI.repository;


import com.lesson1.BikesAPI.model.MotorBike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorBikesRepository extends CrudRepository<MotorBike, Long> {

    boolean existsByBrandAndModel(String brand, String model);
}
