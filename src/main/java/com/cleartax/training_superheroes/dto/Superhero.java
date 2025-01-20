package com.cleartax.training_superheroes.dto;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "superheroes")
public class Superhero {

    @Id
    private String id;
    private String name;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getArchEnemy() {
        return archEnemy;
    }

    public void setArchEnemy(String archEnemy) {
        this.archEnemy = archEnemy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String power;
    private String archEnemy;

    private String universe;
}
