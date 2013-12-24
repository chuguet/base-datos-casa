package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Formato.
 */
public enum Formato {

	/** The blue ray. */
	BLUE_RAY("BLUE-RAY"),

	/** The dvd. */
	DVD("DVD"),

	/** The vhs. */
	VHS("VHS");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Formato getValue(String value) {
		Formato result = null;
		for (Formato formato : Formato.values()) {
			if (formato.getNameId().equals(value)) {
				result = formato;
				break;
			}
		}
		return result;
	}

	/** The nameId. */
	private String nameId;

	/**
	 * Instantiates a new nameId.
	 * 
	 * @param nameId
	 *            the nameId
	 */
	private Formato(String nameId) {
		this.nameId = nameId;
	}

	/**
	 * Gets the nameId.
	 * 
	 * @return the nameId
	 */
	public String getNameId() {
		return this.nameId;
	}
}
