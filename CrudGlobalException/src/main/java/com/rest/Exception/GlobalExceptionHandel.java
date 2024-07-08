package com.rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandel {
	
	@ExceptionHandler(NoSuchElementPresent.class)
    public ResponseEntity<ErrorResponse> handleCustomException(NoSuchElementPresent err) {
        ErrorResponse errorResponse = new ErrorResponse(err.getErrorCode(), err.getErrorMessage(), false);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
	
	

}
