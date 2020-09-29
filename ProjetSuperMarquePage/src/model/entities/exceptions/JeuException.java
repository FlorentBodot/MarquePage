package model.entities.exceptions;

public class JeuException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JeuException() {
	}

	public JeuException(String message) {
		super(message);
	}

	public JeuException(Throwable cause) {
		super(cause);
	}

	public JeuException(String message, Throwable cause) {
		super(message, cause);
	}



}
