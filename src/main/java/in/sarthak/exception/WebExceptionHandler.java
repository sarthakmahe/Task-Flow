package in.sarthak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.sarthak.controller.TaskController;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice(assignableTypes = TaskController.class)
public class WebExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public String handleValidation(ConstraintViolationException ex, RedirectAttributes redirectAttributes) {
		String message = ex.getConstraintViolations().stream()
				.map(ConstraintViolation::getMessage)
				.findFirst()
				.orElse("Invalid input");
		redirectAttributes.addFlashAttribute("titleError", message);
		return "redirect:/tasks";
	}
}
