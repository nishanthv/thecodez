package com.imaginea.codez.exception;

public class ArtifactFetchException extends BaseException {

	/**
	 * 
	 * Creates a new ArtifactFetchException with message and appending the cause
	 * of a caught exception.
	 * 
	 * @param message
	 * @param cause
	 */
	public ArtifactFetchException(String message, Throwable cause) {
		super(message, cause);
	}

}
