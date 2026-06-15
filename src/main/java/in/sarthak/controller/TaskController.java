package in.sarthak.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.sarthak.services.TaskServices;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Controller
@RequestMapping("/tasks")
@Validated
public class TaskController {

	private static final int PAGE_SIZE = 5;

	private final TaskServices taskServices;

	public TaskController(TaskServices taskServices) {
		this.taskServices = taskServices;
	}

	@GetMapping
	public String getTasks(
			@RequestParam(required = false) String q,
			@RequestParam(defaultValue = "0") int page,
			Model model) {

		Page<in.sarthak.models.Task> taskPage = taskServices.searchTasks(q,
				PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "id")));

		model.addAttribute("tasks", taskPage.getContent());
		model.addAttribute("searchQuery", q);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", taskPage.getTotalPages());
		model.addAttribute("totalElements", taskPage.getTotalElements());
		model.addAttribute("totalTasks", taskServices.countAll());
		model.addAttribute("completedTasks", taskServices.countCompleted());
		model.addAttribute("pendingTasks", taskServices.countPending());
		return "tasks";
	}

	@PostMapping
	public String createTasks(
			@RequestParam @NotBlank(message = "Task title is required")
			@Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters") String title,
			RedirectAttributes redirectAttributes) {

		taskServices.createTasks(title);
		redirectAttributes.addFlashAttribute("successMessage", "Task added successfully");
		return "redirect:/tasks";
	}

	@GetMapping("/{id}/delete")
	public String deleteTasks(
			@PathVariable Long id,
			@RequestParam(required = false) String q,
			@RequestParam(defaultValue = "0") int page) {

		taskServices.deleteTasks(id);
		return redirectToTasks(q, page);
	}

	@GetMapping("/{id}/toggle")
	public String toggleTasks(
			@PathVariable Long id,
			@RequestParam(required = false) String q,
			@RequestParam(defaultValue = "0") int page) {

		taskServices.toggleTasks(id);
		return redirectToTasks(q, page);
	}

	private String redirectToTasks(String q, int page) {
		StringBuilder url = new StringBuilder("redirect:/tasks?page=").append(page);
		if (q != null && !q.isBlank()) {
			url.append("&q=").append(URLEncoder.encode(q.trim(), StandardCharsets.UTF_8));
		}
		return url.toString();
	}
}
