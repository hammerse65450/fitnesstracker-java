package de.hammer.fitnesstracker.exception;

public class WorkoutNotFoundException extends RuntimeException {

    public WorkoutNotFoundException(String message) {
        super(message);
    }
}
