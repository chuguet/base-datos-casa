package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaMusicaDTO.
 */
public class BusquedaMusicaDTO extends AbstractBusquedaDTO {

	/** The artista. */
	private String artista;

	/** The decada. */
	private String decada;

	/** The titulo. */
	private String titulo;

	/**
	 * Instantiates a new busqueda libro dto.
	 */
	public BusquedaMusicaDTO() {

	}

	/**
	 * Instantiates a new busqueda libro dto.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param artista
	 *            the artista
	 * @param decada
	 *            the decada
	 */
	public BusquedaMusicaDTO(String titulo, String artista, String decada) {
		super();
		this.titulo = encoding(titulo);
		this.artista = encoding(artista);
		this.decada = encoding(decada);
	}

	/**
	 * Gets the artista.
	 * 
	 * @return the artista
	 */
	public String getArtista() {
		return artista;
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
		return this.titulo.isEmpty() && this.artista.isEmpty()
				&& this.decada.isEmpty();
	}

	/**
	 * Sets the artista.
	 * 
	 * @param artista
	 *            the new artista
	 */
	public void setArtista(String artista) {
		this.artista = artista;
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
