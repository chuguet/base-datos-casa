package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Calificacion.
 */
public enum Calificacion {

	/** The tp. */
	TP("TP", "Todos los p�blicos"),

	/** The M13. */
	M13("M13", "Menores de 13 a�os"),

	/** The M18. */
	M18("M18", "Menores de 18 a�os"),

	/** The M7. */
	M7("M7", "Menores de 7 a�os");

	/** The name id. */
	private String nameId;

	/** The calificacion. */
	private String calificacion;

	/**
	 * Instantiates a new calificacion.
	 * 
	 * @param calificacion
	 *            the calificacion
	 * @param nameId
	 *            the name id
	 */
	private Calificacion(String calificacion, String nameId) {
		this.nameId = nameId;
		this.calificacion = calificacion;
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id
	 */
	public String getNameId() {
		return this.nameId;
	}

	/**
	 * Gets the calificacion.
	 * 
	 * @return the calificacion
	 */
	public String getCalificacion() {
		return this.calificacion;
	}
}
