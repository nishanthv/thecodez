package com.imaginea.codez.exception;

public class CodezException extends Exception {

	private Integer errorCode;

	public CodezException(Integer errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public CodezException(String message, Throwable cause) {
		super(message, cause);
	}
	public CodezException() {
		
	}
	
	public Integer getErrorCode() {
		return this.errorCode;
	}
}
