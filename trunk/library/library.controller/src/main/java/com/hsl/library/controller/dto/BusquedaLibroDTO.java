package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaLibroDTO.
 */
public class BusquedaLibroDTO extends AbstractBusquedaDTO {

	/** The autores. */
	private String autores;

	/** The decada. */
	private String decada;

	/** The titulo. */
	private String titulo;

	/**
	 * Instantiates a new busqueda libro dto.
	 */
	public BusquedaLibroDTO() {

	}

	/**
	 * Instantiates a new busqueda libro dto.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param autores
	 *            the autores
	 * @param decada
	 *            the decada
	 */
	public BusquedaLibroDTO(String titulo, String autores, String decada) {
		super();
		this.titulo = encoding(titulo);
		this.autores = encoding(autores);
		this.decada = encoding(decada);
	}

	/**
	 * Gets the autores.
	 * 
	 * @return the autores
	 */
	public String getAutores() {
		return autores;
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
		return this.titulo.isEmpty() && this.autores.isEmpty()
				&& this.decada.isEmpty();
	}

	/**
	 * Sets the autores.
	 * 
	 * @param autores
	 *            the new autores
	 */
	public void setAutores(String autores) {
		this.autores = autores;
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
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
