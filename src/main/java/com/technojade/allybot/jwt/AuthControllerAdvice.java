package com.technojade.allybot.jwt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class AuthControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseBody> exceptionHandler(Exception e, WebRequest request) {
		ResponseBody responseBody = new ResponseBody();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime currentLocalDateTime = LocalDateTime.now();
		String currentDateTimeStr = formatter.format(currentLocalDateTime);
		responseBody.setTimestamp(currentDateTimeStr);
		responseBody.setMessage(e.getMessage());
		responseBody.setStatus(HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<ResponseBody>(responseBody, HttpStatus.UNAUTHORIZED);
	}
}
