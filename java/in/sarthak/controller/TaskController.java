package in.sarthak.controller;

import in.sarthak.repository.TaskRepository;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import in.sarthak.models.Task;
import in.sarthak.services.TaskServices;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	   private final TaskRepository taskRepository;
	   private final TaskServices taskServices;

	   public TaskController(TaskServices taskServices, TaskRepository taskRepository) {
		 this.taskServices=taskServices;
		 this.taskRepository = taskRepository;
	   }
	   
	   /*
	   @GetMapping()
	   public String getTasks(Model model) {
		   List<Task> tasks=taskServices.getAllTasks();
	       model.addAttribute("tasks",tasks);
		   return "tasks";
	   }
	   
	   
	   
	   @PostMapping
	   public String createTasks(@RequestParam String title) {
		  taskServices.createTasks(title);
		   
		   return "redirect:/tasks";
	   }
	   @GetMapping("/")
	   public String home() {
	       return "redirect:/tasks";
	   }
	
	   
	   
	   @GetMapping("/{id}/delete")
	   public String deleteTasks(@PathVariable Long id) {
		 taskServices.deleteTasks(id);
		   return "redirect:/tasks";
	   }
	   
	   
	   @GetMapping("/{id}/toggle")
	   public String toggleTasks(@PathVariable Long id) {
		 taskServices.toggleTasks(id);
		   return "redirect:/tasks";
	   }
	   */
	   
	   
	   
	    @GetMapping
	    public String getTasks(Model model) {
	        List<Task> tasks = taskServices.getAllTasks();
	        model.addAttribute("tasks", tasks);
	        return "tasks";
	    }

	    @PostMapping
	    public String createTasks(@RequestParam String title) {
	        taskServices.createTasks(title);
	        return "redirect:/tasks";
	    }

	    @GetMapping("/{id}/delete")
	    public String deleteTasks(@PathVariable Long id) {
	        taskServices.deleteTasks(id);
	        return "redirect:/tasks";
	    }

	    @GetMapping("/{id}/toggle")
	    public String toggleTasks(@PathVariable Long id) {
	        taskServices.toggleTasks(id);
	        return "redirect:/tasks";
	    }
	    
	   
		
	}
	   
	   

