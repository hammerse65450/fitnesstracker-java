package de.hammer.fitnesstracker.repo;

import de.hammer.fitnesstracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    void deleteExerciseById(Long id);

    Optional<Exercise> findExerciseById(Long id);
}
