package de.hammer.fitnesstracker.service;

import de.hammer.fitnesstracker.exception.ExerciseNotFoundException;
import de.hammer.fitnesstracker.model.Exercise;
import de.hammer.fitnesstracker.repo.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExerciseService {

    private final ExerciseRepo exerciseRepo;

    @Autowired
    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepo.save(exercise);
    }

    public List<Exercise> findAllExercise() {
        return exerciseRepo.findAll();
    }

    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepo.save(exercise);
    }

    public Exercise findExerciseById(Long id) {

        return exerciseRepo.findExerciseById(id)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise by id " + id + " was not found"));
    }

    public void deleteExercise(Long id) {
        exerciseRepo.deleteExerciseById(id);
    }

}
