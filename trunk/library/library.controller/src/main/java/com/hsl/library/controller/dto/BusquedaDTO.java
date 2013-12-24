package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaDTO.
 */
public class BusquedaDTO {

	/** The director. */
	private String director;

	/** The distribuidora. */
	private String distribuidora;

	/** The genero. */
	private String genero;

	/** The interpretes. */
	private String interpretes;

	/** The titulo. */
	private String titulo;

	/**
	 * Instantiates a new busqueda dto.
	 */
	public BusquedaDTO() {

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
	 * @param distribuidora
	 *            the distribuidora
	 * @param genero
	 *            the genero
	 */
	public BusquedaDTO(String titulo, String director, String interpretes,
			String distribuidora, String genero) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.interpretes = interpretes;
		this.distribuidora = distribuidora;
		this.genero = genero;
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
	 * Gets the distribuidora.
	 * 
	 * @return the distribuidora
	 */
	public String getDistribuidora() {
		return distribuidora;
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
		return this.director.isEmpty() && this.distribuidora.isEmpty()
				&& this.genero.isEmpty() && this.interpretes.isEmpty()
				&& this.titulo.isEmpty();
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
	 * Sets the distribuidora.
	 * 
	 * @param distribuidora
	 *            the new distribuidora
	 */
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
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
