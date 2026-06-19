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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
			@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number cannot be negative") int page,
			@RequestParam(defaultValue = "newest") String sort,
			Model model) {

		String selectedSort = normalizeSort(sort);
		Page<in.sarthak.models.Task> taskPage = taskServices.searchTasks(q,
				PageRequest.of(page, PAGE_SIZE, resolveSort(selectedSort)));

		model.addAttribute("tasks", taskPage.getContent());
		model.addAttribute("searchQuery", q);
		model.addAttribute("selectedSort", selectedSort);
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
			@PathVariable @Positive(message = "Task id must be positive") Long id,
			@RequestParam(required = false) String q,
			@RequestParam(defaultValue = "newest") String sort,
			@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number cannot be negative") int page) {

		taskServices.deleteTasks(id);
		return redirectToTasks(q, sort, page);
	}

	@GetMapping("/{id}/toggle")
	public String toggleTasks(
			@PathVariable @Positive(message = "Task id must be positive") Long id,
			@RequestParam(required = false) String q,
			@RequestParam(defaultValue = "newest") String sort,
			@RequestParam(defaultValue = "0") @Min(value = 0, message = "Page number cannot be negative") int page) {

		taskServices.toggleTasks(id);
		return redirectToTasks(q, sort, page);
	}

	private Sort resolveSort(String sort) {
		return switch (sort) {
			case "oldest" -> Sort.by(Sort.Direction.ASC, "id");
			case "titleAsc" -> Sort.by(Sort.Direction.ASC, "title");
			case "titleDesc" -> Sort.by(Sort.Direction.DESC, "title");
			case "status" -> Sort.by(Sort.Direction.ASC, "completed").and(Sort.by(Sort.Direction.DESC, "id"));
			default -> Sort.by(Sort.Direction.DESC, "id");
		};
	}

	private String normalizeSort(String sort) {
		if (sort == null) {
			return "newest";
		}
		return switch (sort) {
			case "oldest", "titleAsc", "titleDesc", "status" -> sort;
			default -> "newest";
		};
	}

	private String redirectToTasks(String q, String sort, int page) {
		StringBuilder url = new StringBuilder("redirect:/tasks?page=").append(page);
		sort = normalizeSort(sort);
		if (sort != null && !sort.isBlank() && !"newest".equals(sort)) {
			url.append("&sort=").append(URLEncoder.encode(sort.trim(), StandardCharsets.UTF_8));
		}
		if (q != null && !q.isBlank()) {
			url.append("&q=").append(URLEncoder.encode(q.trim(), StandardCharsets.UTF_8));
		}
		return url.toString();
	}
}
