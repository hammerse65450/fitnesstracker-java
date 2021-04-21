package de.hammer.fitnesstracker.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Exercise implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private Integer weight;

    public Exercise(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    public Exercise() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Excercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
