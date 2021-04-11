package com.revature.inventory.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request){
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}
	@ExceptionHandler(NoProductListFoundException.class)
	public ResponseEntity<Object> handleNoProductListFoundException(NoProductListFoundException ex, WebRequest request){
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}
	@ExceptionHandler(UnsuccessfulSaveOperationException.class)
	public ResponseEntity<Object>handleUnsuccessfulSaveOperationException(UnsuccessfulSaveOperationException ex, WebRequest request){
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}
	@ExceptionHandler(UnsuccessfulDeleteOperationException.class)
	public ResponseEntity<Object> handleUnsuccesfulDeletOperationException(UnsuccessfulDeleteOperationException ex, WebRequest request){
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
}
}