package in.sarthak.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sarthak.dto.TaskRequest;
import in.sarthak.models.Task;
import in.sarthak.services.TaskServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Manage todo tasks")
public class TaskApiController {

	private final TaskServices taskServices;

	public TaskApiController(TaskServices taskServices) {
		this.taskServices = taskServices;
	}

	@GetMapping
	@Operation(summary = "Get all tasks")
	public List<Task> getAllTasks() {
		return taskServices.getAllTasks();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get a task by ID")
	public Task getTaskById(@PathVariable Long id) {
		return taskServices.getTaskById(id);
	}

	@PostMapping
	@Operation(summary = "Create a new task")
	public ResponseEntity<Task> createTask(@RequestBody TaskRequest request) {
		Task task = taskServices.createTasks(request.getTitle());
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}

	@PatchMapping("/{id}/toggle")
	@Operation(summary = "Toggle task completion status")
	public Task toggleTask(@PathVariable Long id) {
		return taskServices.toggleTasks(id);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a task")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		taskServices.deleteTasks(id);
		return ResponseEntity.noContent().build();
	}
}
