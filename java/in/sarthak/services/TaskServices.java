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


	    public Task createTasks(String title) {
		Task task=new Task();
		task.setTitle(title);
		task.setCompleted(false);
		return taskRepository.save(task);
	    }


	     public void deleteTasks(Long id) {
	     taskRepository.deleteById(id);
		  }


	   public Task toggleTasks(Long id) {
	   Task task=taskRepository.findById(id)
                      .orElseThrow(() -> new IllegalArgumentException("Invalid tasks"));
       task.setCompleted(!task.isCompleted());
       return taskRepository.save(task);
	}


	    public Task getTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid tasks"));
	}

}
