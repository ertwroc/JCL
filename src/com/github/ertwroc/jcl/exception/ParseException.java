package com.github.ertwroc.jcl.exception;

/**
 * Exception informing about parse errors 
 * @author ert
 *
 */
public class ParseException extends RuntimeException {
	private static final long serialVersionUID = -3564259487672565914L;

	public ParseException() {
		super();
	}

	public ParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParseException(String message) {
		super(message);
	}

	public ParseException(Throwable cause) {
		super(cause);
	}
}
