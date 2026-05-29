package in.sarthak.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.sarthak.models.Task;
import in.sarthak.repository.TaskRepository;

@Service
public class TaskServices {

	private final TaskRepository taskRepository;
	
	
	public TaskServices(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}


	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}


	public void createTasks(String title) {
		Task task=new Task();
		task.setTitle(title);
		task.setCompleted(false);
		taskRepository.save(task);
	
	}


	public void deleteTasks(Long id) {
	     taskRepository.deleteById(id);
		
	}


	public void toggleTasks(Long id) {
	   Task task=taskRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Invalid tasks"));
   task.setCompleted(!task.isCompleted());
   taskRepository.save(task);
	}


   
	
	
	
}
