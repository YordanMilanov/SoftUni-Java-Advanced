package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Workout{
    List<Exercise> exercises;
    String type;
    int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        int topBurnedCalories = 0;
        for (Exercise e : exercises) {
            if (e.getBurnedCalories() > topBurnedCalories) {
                topBurnedCalories = e.getBurnedCalories();
            }
        }

        for (Exercise e : exercises) {
            if (e.getBurnedCalories() == topBurnedCalories) {
                return e;
            }
        }
        return null;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        int loop = 0;
        sb.append("Workout type: " + type + "\n");
        for (Exercise e : exercises) {
            sb.append(e);
            loop++;
            if(loop < exercises.size()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
