package com.imaginea.codez.exception;

public class BaseException extends Exception {

	/**
	 * 
	 * Creates a new BaseException with message and appending the cause of a
	 * caught exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
}
