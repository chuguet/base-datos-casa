package com.hsl.library.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class BusquedaDTO.
 */
public class BusquedaDTO {

	/** The apellidos. */
	private String apellidos;

	/** The nombre. */
	private String nombre;

	/**
	 * Instantiates a new busqueda dto.
	 */
	public BusquedaDTO() {
	}

	/**
	 * Instantiates a new busqueda dto.
	 * 
	 * @param nombre
	 *            the nombre
	 * @param apellidos
	 *            the apellidos
	 */
	public BusquedaDTO(String nombre, String apellidos) {
		this.setNombre(nombre);
		this.setApellidos(apellidos);
	}

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Checks if is empty.
	 * 
	 * @return the boolean
	 */
	public Boolean isEmpty() {
		return nombre.isEmpty() && apellidos.isEmpty();
	}

	/**
	 * Sets the apellidos.
	 * 
	 * @param apellidos
	 *            the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
