package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Genero.
 */
public enum Genero {

	/** The accion. */
	ACCION("Acción"),

	/** The aventura. */
	AVENTURA("Aventura"),

	/** The belico. */
	BELICO("Bélico"),

	/** The catastrofe. */
	CATASTROFE("Catástrofe"),
	
	/** The ciencia ficcion. */
	CIENCIA_FICCION("Ciencia Ficción"),

	/** The comedia. */
	COMEDIA("Comedia"),

	/** The dibujos. */
	DIBUJOS("Dibujos"),
	
	/** The drama. */
	DRAMA("Drama"),

	/** The explotacion. */
	EXPLOTACION("Explotación"),

	/** The fantasia. */
	FANTASIA("Fantasía"),

	/** The melodrama. */
	MELODRAMA("Melodrama"),

	/** The musical. */
	MUSICAL("Musical"),

	/** The otros. */
	OTROS("Otros"),

	/** The pornografia. */
	PORNOGRAFIA("Pornografía"),

	/** The romantico. */
	ROMANTICO("Romantico"),

	/** The suspense. */
	SUSPENSE("Suspense"),

	/** The terror. */
	TERROR("Terror");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Genero getValue(String value) {
		Genero result = null;
		for (Genero genero : Genero.values()) {
			if (genero.getNameId().equals(value)) {
				result = genero;
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
	private Genero(String nameId) {
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
