package gable.wallet.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(value = "gable.wallet")
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex){
		Map<String, Object> errors = new HashMap<>();
		errors.put("timestamp", LocalDateTime.now());
		errors.put("message", ex.getMessage());
		errors.put("code",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
		Map<String, Object> errors = new HashMap<>();
		errors.put("timestamp", LocalDateTime.now());
		errors.put("message", ex.getMessage());
		errors.put("code", HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<Map<String, Object>> handleNotEnoughMoneyException(NotEnoughMoneyException ex){
		Map<String, Object> errors = new HashMap<>();
		errors.put("timestamp", LocalDateTime.now());
		errors.put("message", ex.getMessage());
		errors.put("code", HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
	}
}
