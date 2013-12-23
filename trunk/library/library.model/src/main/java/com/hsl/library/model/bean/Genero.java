package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Genero.
 */
public enum Genero {

	/** The drama. */
	DRAMA("Drama"),

	/** The comedia. */
	COMEDIA("Comedia"),

	/** The accion. */
	ACCION("Acción"),

	/** The aventura. */
	AVENTURA("Aventura"),

	/** The terror. */
	TERROR("Terror"),

	/** The ciencia ficcion. */
	CIENCIA_FICCION("Ciencia Ficción"),

	/** The romantico. */
	ROMANTICO("Romantico"),

	/** The musical. */
	MUSICAL("Musical"),

	/** The melodrama. */
	MELODRAMA("Melodrama"),

	/** The catastrofe. */
	CATASTROFE("Catástrofe"),

	/** The suspense. */
	SUSPENSE("Suspense"),

	/** The fantasia. */
	FANTASIA("Fantasía"),

	/** The pornografia. */
	PORNOGRAFIA("Pornografía"),

	/** The explotacion. */
	EXPLOTACION("Explotación"),

	/** The belico. */
	BELICO("Bélico"),

	/** The otros. */
	OTROS("Otros");

	/** The genero. */
	private String genero;

	/**
	 * Instantiates a new genero.
	 * 
	 * @param genero
	 *            the genero
	 */
	private Genero(String genero) {
		this.genero = genero;
	}

	/**
	 * Gets the genero.
	 * 
	 * @return the genero
	 */
	public String getGenero() {
		return this.genero;
	}
}
