package com.lesson1.BikesAPI.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Part {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String manufacturer;
    private String model;
    private double price;

    public Part(String name, String manufacturer, String model, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }
}
