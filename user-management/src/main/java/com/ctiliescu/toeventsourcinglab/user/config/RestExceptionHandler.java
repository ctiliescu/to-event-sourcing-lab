package com.ctiliescu.toeventsourcinglab.user.config;

import com.ctiliescu.toeventsourcinglab.user.model.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	ResponseEntity<String> httpStatusExceptionHandler(NotFoundException e) {
		logger.warn("Client error", e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

}
