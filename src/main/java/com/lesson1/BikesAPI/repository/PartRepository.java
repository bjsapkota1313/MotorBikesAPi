package com.lesson1.BikesAPI.repository;

import com.lesson1.BikesAPI.model.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part,Long> {
}
