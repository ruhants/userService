package com.userService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse> userNotFoundEx(UserNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse status = ApiResponse.builder().message(message).success(true)
		.status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(status,HttpStatus.NOT_FOUND);
		
	}

}
