package model.entities.exceptions;

public class AnimeException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * @param message
	 * @param cause
	 */
	public AnimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AnimeException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param message2
	 */
	public AnimeException(String message, String message2) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AnimeException(Throwable cause) {
		super(cause);
	}

}
