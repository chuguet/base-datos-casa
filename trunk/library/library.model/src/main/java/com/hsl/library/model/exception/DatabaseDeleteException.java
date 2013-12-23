package com.hsl.library.model.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AppException.
 */
public class DatabaseDeleteException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public DatabaseDeleteException() {
		super();
	}

	/**
	 * Instantiates a new database delete exception.
	 * 
	 * @param e
	 *            the e
	 */
	public DatabaseDeleteException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public DatabaseDeleteException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new database delete exception.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public DatabaseDeleteException(String message, Exception e) {
		super(message, e);
	}
}