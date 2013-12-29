package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaDTO.
 */
public class BusquedaPeliculaDTO extends AbstractBusquedaDTO {

	/** The decada. */
	private String decada;

	/** The director. */
	private String director;

	/** The genero. */
	private String genero;

	/** The interpretes. */
	private String interpretes;

	/** The titulo. */
	private String titulo;

	/**
	 * Instantiates a new busqueda dto.
	 */
	public BusquedaPeliculaDTO() {

	}

	/**
	 * Instantiates a new busqueda dto.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param director
	 *            the director
	 * @param interpretes
	 *            the interpretes
	 * @param decada
	 *            the decada
	 * @param genero
	 *            the genero
	 */
	public BusquedaPeliculaDTO(String titulo, String director,
			String interpretes, String decada, String genero) {
		super();
		this.genero = encoding(genero);
		this.titulo = encoding(titulo);
		this.director = encoding(director);
		this.interpretes = encoding(interpretes);
		this.decada = encoding(decada);
	}

	/**
	 * Gets the decada.
	 * 
	 * @return the decada
	 */
	public String getDecada() {
		return decada;
	}

	/**
	 * Gets the director.
	 * 
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Gets the genero.
	 * 
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Gets the interpretes.
	 * 
	 * @return the interpretes
	 */
	public String getInterpretes() {
		return interpretes;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Checks if is empty.
	 * 
	 * @return the boolean
	 */
	public Boolean isEmpty() {
		return this.director.isEmpty() && this.decada.isEmpty()
				&& this.genero.isEmpty() && this.interpretes.isEmpty()
				&& this.titulo.isEmpty();
	}

	/**
	 * Sets the decada.
	 * 
	 * @param decada
	 *            the new decada
	 */
	public void setDecada(String decada) {
		this.decada = decada;
	}

	/**
	 * Sets the director.
	 * 
	 * @param director
	 *            the new director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Sets the genero.
	 * 
	 * @param genero
	 *            the new genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Sets the interpretes.
	 * 
	 * @param interpretes
	 *            the new interpretes
	 */
	public void setInterpretes(String interpretes) {
		this.interpretes = interpretes;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
