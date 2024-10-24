package ca.taskify.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, String> taskData) {
        String taskName = taskData.get("name");
        String dueDateString = taskData.get("dueDate");

        LocalDate dueDate;
        try {
            dueDate = LocalDate.parse(dueDateString); // Parse the string to LocalDate
        } catch (DateTimeParseException e) {
            // Handle invalid date format
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Create a new Task object
        Task newTask = new Task();
        newTask.setTaskName(taskName);
        newTask.setDate(dueDate); // Assuming `date` is of type LocalDate in Task
        newTask.setCompleted(false); // Default completed status

        // Save the task to the database
        Task savedTask = repository.save(newTask);

        // Return the saved task with CREATED status
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
}
