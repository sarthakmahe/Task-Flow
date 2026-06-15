package in.sarthak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.sarthak.models.Task;
import in.sarthak.repository.TaskRepository;

@Service
public class TaskServices {

	private final TaskRepository taskRepository;

	public TaskServices(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public Page<Task> searchTasks(String keyword, Pageable pageable) {
		if (keyword == null || keyword.isBlank()) {
			return taskRepository.findAll(pageable);
		}
		return taskRepository.findByTitleContainingIgnoreCase(keyword.trim(), pageable);
	}

	public Task createTasks(String title) {
		Task task = new Task();
		task.setTitle(title.trim());
		task.setCompleted(false);
		return taskRepository.save(task);
	}

	public void deleteTasks(Long id) {
		taskRepository.deleteById(id);
	}

	public Task toggleTasks(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
		task.setCompleted(!task.isCompleted());
		return taskRepository.save(task);
	}

	public Task getTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
	}

	public long countAll() {
		return taskRepository.count();
	}

	public long countCompleted() {
		return taskRepository.countByCompleted(true);
	}

	public long countPending() {
		return taskRepository.countByCompleted(false);
	}
}
