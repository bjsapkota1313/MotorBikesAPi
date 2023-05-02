package com.lesson1.BikesAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class Engine {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String type;
    private double volume;

    public Engine(String type, double volume) {
        this.type = type;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (!Objects.equals(id, engine.id)) return false;
        if (Double.compare(engine.volume, volume) != 0) return false;
        return Objects.equals(type, engine.type);
    }
}
