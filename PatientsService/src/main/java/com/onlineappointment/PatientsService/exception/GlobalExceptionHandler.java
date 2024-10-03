package com.onlineappointment.PatientsService.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setPath(webRequest.getDescription(false));
		errorDetails.setErrorCode("RESOURCE_NOT_FOUND_EXCEPTION");
		errorDetails.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<ErrorDetails> handleServiceUnavailableException(ServiceUnavailableException exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setPath(webRequest.getDescription(false));
		errorDetails.setErrorCode("SERVICE_UNAVAILABLE_EXCEPTION");
		errorDetails.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.SERVICE_UNAVAILABLE);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception exception,WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setPath(webRequest.getDescription(false));
		errorDetails.setErrorCode("INTERNAL_SERVER_ERROR");
		errorDetails.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
