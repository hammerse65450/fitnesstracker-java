package de.hammer.fitnesstracker.repo;

import de.hammer.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutRepo extends JpaRepository<Workout, Long> {

    void deleteWorkoutById(Long id);

    Optional<Workout> findWorkoutById(Long id);
}
