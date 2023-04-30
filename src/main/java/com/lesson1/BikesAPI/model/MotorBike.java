package com.lesson1.BikesAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class MotorBike {

    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String model;
    private String engine;
    private String color;
    private double price;

    public MotorBike(String brand, String model, String engine, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MotorBike motorBike)) {
            return false;
        }
        return Objects.equals(id,motorBike.id) && Objects.equals(brand, motorBike.brand) && Objects.equals(model, motorBike.model)
                && Objects.equals(engine, motorBike.engine) && Objects.equals(color, motorBike.color) && price == motorBike.price;
    }

}
