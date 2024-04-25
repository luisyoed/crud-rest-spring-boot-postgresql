package com.ebitware.prueba.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ebitware.prueba.vo.ExceptionResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleBindException(final BindException exception,
			final HttpServletRequest request) {

		String errorMessage = "";
		exception.getFieldErrors().forEach(error -> log.error(error.getField() + " " + error.getDefaultMessage()));
		for (FieldError error : exception.getFieldErrors()) {
			errorMessage = errorMessage.concat(error.getField()).concat(": ").concat(error.getDefaultMessage())
					.concat(",");
		}

		ExceptionResponse error = ExceptionResponse.builder().error(errorMessage)
				.status(HttpStatus.BAD_REQUEST.toString()).build();
		return error;
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
		ExceptionResponse error = ExceptionResponse.builder().error("Sin Información")
				.status(HttpStatus.NOT_FOUND.toString()).build();
		return error;
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleNullPointerExceptionException(NullPointerException ex, HttpServletRequest request) {
		ExceptionResponse error = ExceptionResponse.builder().error("User does not exist")
				.status(HttpStatus.NOT_FOUND.toString()).build();
		return error;
	}
}
