package jcl;

public class JCLException extends RuntimeException {
	private static final long serialVersionUID = 6380758409856450216L;

	public JCLException() {
		super();
	}

	public JCLException(String message, Throwable cause) {
		super(message, cause);
	}

	public JCLException(String message) {
		super(message);
	}

	public JCLException(Throwable cause) {
		super(cause);
	}
}
