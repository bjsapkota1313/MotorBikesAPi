package com.lesson1.BikesAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine {
    private long id;
    private String type;
    private double power;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (id != engine.id) return false;
        if (Double.compare(engine.power, power) != 0) return false;
        return Objects.equals(type, engine.type);
    }
}
