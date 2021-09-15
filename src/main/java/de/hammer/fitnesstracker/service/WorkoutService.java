package de.hammer.fitnesstracker.service;

import de.hammer.fitnesstracker.exception.WorkoutNotFoundException;
import de.hammer.fitnesstracker.model.Workout;
import de.hammer.fitnesstracker.repo.WorkoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkoutService {

    private final WorkoutRepo workoutRepo;

    @Autowired
    public WorkoutService(WorkoutRepo workoutRepo){
        this.workoutRepo = workoutRepo;
    }

    public Workout addWorkout(Workout workout){
        return workoutRepo.save(workout);
    }

    public List<Workout> findAllWorkouts(){
        return workoutRepo.findAll();
    }

    public Workout updateWorkout(Workout workout){
        return workoutRepo.save(workout);
    }

    public Workout findWorkoutById(Long id){
        return workoutRepo.findWorkoutById(id).orElseThrow(()-> new WorkoutNotFoundException("Workout with id" + id + " was not found"));
    }

    public void deleteWorkout(Long id) {
        workoutRepo.deleteWorkoutById(id);
    }
}
