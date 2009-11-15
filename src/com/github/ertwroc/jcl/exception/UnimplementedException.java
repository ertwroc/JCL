package com.github.ertwroc.jcl.exception;

public class UnimplementedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnimplementedException() {
		super();
	}

	public UnimplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnimplementedException(String message) {
		super(message);
	}

	public UnimplementedException(Throwable cause) {
		super(cause);
	}
}
