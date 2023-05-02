package com.lesson1.BikesAPI.repository;

import com.lesson1.BikesAPI.model.Engine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends CrudRepository<Engine, Long> {

}
