package in.sarthak.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

	@NotBlank(message = "Title is required")
	@Size(min = 1, max = 200, message = "Title must be between 1 and 200 characters")
	@Schema(example = "Buy groceries")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
