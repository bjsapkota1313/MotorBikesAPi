package com.lesson1.BikesAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Part {
    @Id
    private Long id;
    private String name;
    private String manufacturer;
    private String model;

    public Part(String name, String manufacturer, String model) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
    }
}
