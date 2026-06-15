package in.sarthak.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 1, max = 200)
	@Column(nullable = false, length = 200)
	private String title;

	private boolean completed;

	   
	   public String getTitle() {
		   return title;
	   }
	   public void setTitle(String title) {
		   this.title = title;
	   }
	   
	   public Long getId() {
		   return id;
	   }
	   
	   public void setId(Long id) {
		   this.id = id;
	   }
	   
	   public boolean isCompleted() {
		   return completed;
	   }
	   
	   public void setCompleted(boolean completed) {
		   this.completed = completed;
	   }	
}
