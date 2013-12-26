package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaLibroDTO.
 */
public class BusquedaLibroDTO extends AbstractBusquedaDTO {

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
	 */
	public BusquedaLibroDTO(String titulo) {
		super();
		this.titulo = titulo;
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
		return this.titulo.isEmpty();
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = encoding(titulo);
	}

}
