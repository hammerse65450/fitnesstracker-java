package de.hammer.fitnesstracker.resource;

import de.hammer.fitnesstracker.model.Workout;
import de.hammer.fitnesstracker.model.Workout;
import de.hammer.fitnesstracker.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutResource {

    private final WorkoutService workoutService;

    public WorkoutResource(WorkoutService workoutService){ this.workoutService = workoutService;}

    @GetMapping("/all")
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        List<Workout> workouts = workoutService.findAllWorkouts();
        return new ResponseEntity<>(workouts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable("id") Long id) {

        Workout workout = workoutService.findWorkoutById(id);

        return new ResponseEntity<Workout>(workout, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {

        Workout newWorkout = workoutService.addWorkout(workout);

        return new ResponseEntity<>(newWorkout, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Workout> updateWorkout(@RequestBody Workout workout) {

        Workout updatedWorkout = workoutService.updateWorkout(workout);

        return new ResponseEntity<>(updatedWorkout, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorkout(@PathVariable("id") Long id) {

        workoutService.deleteWorkout(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
