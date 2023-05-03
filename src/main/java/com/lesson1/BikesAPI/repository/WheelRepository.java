package com.lesson1.BikesAPI.repository;

import com.lesson1.BikesAPI.model.Wheel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends CrudRepository<Wheel, Long> {
}
