package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Calificacion.
 */
public enum Calificacion {

	/** The M13. */
	M13("Menores de 13 años"),

	/** The M18. */
	M18("Menores de 18 años"),

	/** The M7. */
	M7("Menores de 7 años"),

	/** The tp. */
	TP("Todos los públicos");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Calificacion getValue(String value) {
		Calificacion result = null;
		for (Calificacion calificacion : Calificacion.values()) {
			if (calificacion.getNameId().equals(value)) {
				result = calificacion;
				break;
			}
		}
		return result;
	}

	/** The nameId. */
	private String nameId;

	/**
	 * Instantiates a new calificacion.
	 * 
	 * @param nameId
	 *            the name id
	 */
	private Calificacion(String nameId) {
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
