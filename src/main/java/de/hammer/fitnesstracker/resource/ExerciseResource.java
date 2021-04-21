package de.hammer.fitnesstracker.resource;

import de.hammer.fitnesstracker.model.Exercise;
import de.hammer.fitnesstracker.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseResource {

    private final ExerciseService exerciseService;

    public ExerciseResource(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exercise>> getAllExercises(){

        List<Exercise> exercises = exerciseService.findAllExercise();

        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Exercise> getAllExercises(@PathVariable("id") Long id){

        Exercise exercise = exerciseService.findExerciseById(id);

        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise){

        Exercise newExercise = exerciseService.addExercise(exercise);

        return new ResponseEntity<>(newExercise, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise exercise){

        Exercise updatedExercise = exerciseService.updateExercise(exercise);

        return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteExercise(@PathVariable("id") Long id){

        exerciseService.deleteExercise(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
