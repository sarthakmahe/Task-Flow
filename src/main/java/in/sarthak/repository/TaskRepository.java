package in.sarthak.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import in.sarthak.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByTitleContainingIgnoreCase(String title);

	Page<Task> findByTitleContainingIgnoreCase(String title, Pageable pageable);

	List<Task> findByCompletedAndTitleContainingIgnoreCase(boolean completed, String title);

	long countByCompleted(boolean completed);
}
