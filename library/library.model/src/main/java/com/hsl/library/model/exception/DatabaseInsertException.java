package com.hsl.library.model.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AppException.
 */
public class DatabaseInsertException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public DatabaseInsertException() {
		super();
	}

	/**
	 * Instantiates a new database delete exception.
	 * 
	 * @param e
	 *            the e
	 */
	public DatabaseInsertException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public DatabaseInsertException(String message) {
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
	public DatabaseInsertException(String message, Exception e) {
		super(message, e);
	}
}