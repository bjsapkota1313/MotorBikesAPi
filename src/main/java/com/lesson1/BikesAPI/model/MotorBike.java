package com.lesson1.BikesAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotorBike {

    private long id;
    private String brand;
    private String model;
    private String engine;
    private String color;
    private double price;
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MotorBike)) {
            return false;
        }
        MotorBike motorBike = (MotorBike) o;
        return Objects.equals(brand, motorBike.brand) && Objects.equals(model, motorBike.model)
                && Objects.equals(engine, motorBike.engine) && Objects.equals(color, motorBike.color) && price == motorBike.price;
    }
}
