package com.hsl.library.model.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Libro.
 */
@Entity
@Table(name = "LIBRO")
public class Libro implements IModelTable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -176212295054859957L;

	/**
	 * Gets the serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The autores. */
	@Basic
	@Column(name = "AUTORES")
	private String autores;

	/** The coleccion. */
	@Basic
	@Column(name = "COLECCION")
	private String coleccion;

	/** The descripcion. */
	@Basic
	@Column(name = "DESCRIPCION")
	private String descripcion;

	/** The edicion. */
	@Basic
	@Column(name = "EDICION")
	private String edicion;

	/** The encuadernacion. */
	@Basic
	@Column(name = "ENCUADERNACION")
	private String encuadernacion;

	/** The fecha edicion. */
	@Basic
	@Column(name = "FECHA_EDICION")
	private Date fechaEdicion;

	/** The fecha impresion. */
	@Basic
	@Column(name = "FECHA_IMPRESION")
	private Date fechaImpresion;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIBRO")
	private Integer id;

	/** The isbn10. */
	@Basic
	@Column(name = "ISBN10", unique = true)
	private String isbn10;

	/** The isbn13. */
	@Basic
	@Column(name = "ISBN13", unique = true)
	private String isbn13;

	/** The lengua traduccion. */
	@Basic
	@Column(name = "LENGUA_TRADUCCION")
	private String lenguaTraduccion;

	/** The lengua publicacion. */
	@Basic
	@Column(name = "LENGUA_PUBLICACION")
	private String lenguaPublicacion;

	/** The materias. */
	@Basic
	@Column(name = "MATERIAS")
	private String materias;

	/** The precio. */
	@Basic
	@Column(name = "PRECIO")
	private Double precio;

	/** The publicacion. */
	@Basic
	@Column(name = "PUBLICACION")
	private String publicacion;

	/** The titulo. */
	@Basic
	@Column(name = "TITULO")
	private String titulo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (coleccion == null) {
			if (other.coleccion != null)
				return false;
		} else if (!coleccion.equals(other.coleccion))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (edicion == null) {
			if (other.edicion != null)
				return false;
		} else if (!edicion.equals(other.edicion))
			return false;
		if (encuadernacion == null) {
			if (other.encuadernacion != null)
				return false;
		} else if (!encuadernacion.equals(other.encuadernacion))
			return false;
		if (fechaEdicion == null) {
			if (other.fechaEdicion != null)
				return false;
		} else if (!fechaEdicion.equals(other.fechaEdicion))
			return false;
		if (fechaImpresion == null) {
			if (other.fechaImpresion != null)
				return false;
		} else if (!fechaImpresion.equals(other.fechaImpresion))
			return false;
		if (isbn10 == null) {
			if (other.isbn10 != null)
				return false;
		} else if (!isbn10.equals(other.isbn10))
			return false;
		if (isbn13 == null) {
			if (other.isbn13 != null)
				return false;
		} else if (!isbn13.equals(other.isbn13))
			return false;
		if (lenguaTraduccion == null) {
			if (other.lenguaTraduccion != null)
				return false;
		} else if (!lenguaTraduccion.equals(other.lenguaTraduccion))
			return false;
		if (lenguaPublicacion == null) {
			if (other.lenguaPublicacion != null)
				return false;
		} else if (!lenguaPublicacion.equals(other.lenguaPublicacion))
			return false;
		if (materias == null) {
			if (other.materias != null)
				return false;
		} else if (!materias.equals(other.materias))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (publicacion == null) {
			if (other.publicacion != null)
				return false;
		} else if (!publicacion.equals(other.publicacion))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
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
	 * Gets the coleccion.
	 * 
	 * @return the coleccion
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Gets the edicion.
	 * 
	 * @return the edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * Gets the encuadernacion.
	 * 
	 * @return the encuadernacion
	 */
	public String getEncuadernacion() {
		return encuadernacion;
	}

	/**
	 * Gets the fecha edicion.
	 * 
	 * @return the fecha edicion
	 */
	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	/**
	 * Gets the fecha impresion.
	 * 
	 * @return the fecha impresion
	 */
	public Date getFechaImpresion() {
		return fechaImpresion;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the isbn10.
	 * 
	 * @return the isbn10
	 */
	public String getIsbn10() {
		return isbn10;
	}

	/**
	 * Gets the isbn13.
	 * 
	 * @return the isbn13
	 */
	public String getIsbn13() {
		return isbn13;
	}

	/**
	 * Gets the lengua traduccion.
	 * 
	 * @return the lengua traduccion
	 */
	public String getLenguaTraduccion() {
		return lenguaTraduccion;
	}

	/**
	 * Gets the lengua publicacion.
	 * 
	 * @return the lengua publicacion
	 */
	public String getLenguaPublicacion() {
		return lenguaPublicacion;
	}

	/**
	 * Gets the materias.
	 * 
	 * @return the materias
	 */
	public String getMaterias() {
		return materias;
	}

	/**
	 * Gets the precio.
	 * 
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * Gets the publicacion.
	 * 
	 * @return the publicacion
	 */
	public String getPublicacion() {
		return publicacion;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result
				+ ((coleccion == null) ? 0 : coleccion.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((edicion == null) ? 0 : edicion.hashCode());
		result = prime * result
				+ ((encuadernacion == null) ? 0 : encuadernacion.hashCode());
		result = prime * result
				+ ((fechaEdicion == null) ? 0 : fechaEdicion.hashCode());
		result = prime * result
				+ ((fechaImpresion == null) ? 0 : fechaImpresion.hashCode());
		result = prime * result + ((isbn10 == null) ? 0 : isbn10.hashCode());
		result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
		result = prime * result
				+ ((lenguaTraduccion == null) ? 0 : lenguaTraduccion.hashCode());
		result = prime
				* result
				+ ((lenguaPublicacion == null) ? 0 : lenguaPublicacion
						.hashCode());
		result = prime * result
				+ ((materias == null) ? 0 : materias.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result
				+ ((publicacion == null) ? 0 : publicacion.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
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
	 * Sets the coleccion.
	 * 
	 * @param coleccion
	 *            the new coleccion
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Sets the edicion.
	 * 
	 * @param edicion
	 *            the new edicion
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	/**
	 * Sets the encuadernacion.
	 * 
	 * @param encuadernacion
	 *            the new encuadernacion
	 */
	public void setEncuadernacion(String encuadernacion) {
		this.encuadernacion = encuadernacion;
	}

	/**
	 * Sets the fecha edicion.
	 * 
	 * @param fechaEdicion
	 *            the new fecha edicion
	 */
	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	/**
	 * Sets the fecha impresion.
	 * 
	 * @param fechaImpresion
	 *            the new fecha impresion
	 */
	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the isbn10.
	 * 
	 * @param isbn10
	 *            the new isbn10
	 */
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	/**
	 * Sets the isbn13.
	 * 
	 * @param isbn13
	 *            the new isbn13
	 */
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	/**
	 * Sets the lengua traduccion.
	 * 
	 * @param lenguaTraduccion
	 *            the new legua traduccion
	 */
	public void setLenguaTraduccion(String lenguaTraduccion) {
		this.lenguaTraduccion = lenguaTraduccion;
	}

	/**
	 * Sets the lengua publicacion.
	 * 
	 * @param lenguaPublicacion
	 *            the new lengua publicacion
	 */
	public void setLenguaPublicacion(String lenguaPublicacion) {
		this.lenguaPublicacion = lenguaPublicacion;
	}

	/**
	 * Sets the materias.
	 * 
	 * @param materias
	 *            the new materias
	 */
	public void setMaterias(String materias) {
		this.materias = materias;
	}

	/**
	 * Sets the precio.
	 * 
	 * @param precio
	 *            the new precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * Sets the publicacion.
	 * 
	 * @param publicacion
	 *            the new publicacion
	 */
	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
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
