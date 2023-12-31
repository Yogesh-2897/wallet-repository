package com.user.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.wallet.utility.ApplicationConstants;

@RestControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<CustomExceptionResponse> customExceptionHandler(CustomException ex) {
		CustomExceptionResponse response = new CustomExceptionResponse();
		response.setDetailedMessage(ex.getDetailedMessage());
		response.setErrors(ex.getErrors());
		response.setHttpError(ex.getHttpError());
		response.setHttpErrorCode(ex.getHttpErrorCode());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomExceptionResponse> exceptionHandler(Exception ex) {
		CustomExceptionResponse response = new CustomExceptionResponse();
		response.setDetailedMessage(ex.getMessage());
		response.setErrors(null);
		response.setHttpError(ex.getMessage());
		response.setHttpErrorCode(ApplicationConstants.FAILURE_CODE);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
