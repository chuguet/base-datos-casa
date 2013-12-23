package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Formato.
 */
public enum Formato {

	/** The vhs. */
	VHS("VHS"),

	/** The dvd. */
	DVD("DVD"),

	/** The blue ray. */
	BLUE_RAY("BLUE-RAY");

	/** The formato. */
	private String formato;

	/**
	 * Instantiates a new formato.
	 * 
	 * @param formato
	 *            the formato
	 */
	private Formato(String formato) {
		this.formato = formato;
	}

	/**
	 * Gets the formato.
	 * 
	 * @return the formato
	 */
	public String getFormato() {
		return this.formato;
	}
}
