package com.lesson1.BikesAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Wheel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private double size;

    public Wheel(String brand, String model, double size) {
        this.brand = brand;
        this.model = model;
        this.size = size;
    }
}
