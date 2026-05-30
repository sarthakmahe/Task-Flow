package in.sarthak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarthak.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	   
	
}
