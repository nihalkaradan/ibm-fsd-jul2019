package com.examples.empapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examples.empapp.model.ResponseMessage;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleAppExcpetion(Exception e) {
		ResponseMessage resMsg = new ResponseMessage("Failure", e.getMessage(), e.getCause());
		return ResponseEntity.badRequest().body(resMsg);
	}	

}
