package de.hammer.fitnesstracker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Workout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    @OneToMany
    private List<Exercise> exercises;

    public Workout(String name, List<Exercise> exercises){
        this.name = name;
        this.exercises = exercises;
    }

    public Workout(){

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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name=" + name + "}";
    }
}
