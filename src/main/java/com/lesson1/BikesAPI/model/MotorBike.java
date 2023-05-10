package com.lesson1.BikesAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class MotorBike {

    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String model;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Engine engine;
    private String color;
    private double price;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Wheel> wheels = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Part> parts = new ArrayList<>();

    public MotorBike(String brand, String model, Engine engine, String color, double price) {
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
        return Objects.equals(id, motorBike.id) && Objects.equals(brand, motorBike.brand) && Objects.equals(model, motorBike.model)
                && Objects.equals(engine, motorBike.engine) && Objects.equals(color, motorBike.color) && price == motorBike.price;
    }

}
