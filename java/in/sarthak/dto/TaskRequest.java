package in.sarthak.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class TaskRequest {

	@Schema(example = "Buy groceries")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
