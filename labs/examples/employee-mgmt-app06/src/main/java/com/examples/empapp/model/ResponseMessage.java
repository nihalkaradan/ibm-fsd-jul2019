package com.examples.empapp.model;

public class ResponseMessage {	
	String status;
	String message;
	Throwable cause;
	
	public ResponseMessage(String status, String message) {
		 this.status = status;
		 this.message = message;
	}
	
	public ResponseMessage(String status, String message, Throwable cause) {
		 this.status = status;
		 this.message = message;
		 this.cause = cause;
	}	

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
