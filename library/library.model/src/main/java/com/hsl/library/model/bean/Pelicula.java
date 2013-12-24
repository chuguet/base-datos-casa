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
 * The Class Paciente.
 */
@Entity
@Table(name = "PELICULA")
public class Pelicula implements IModelTable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5448220718218818850L;

	/** The calificacion. */
	@Basic
	@Column(name = "CALIFICACION")
	private Calificacion calificacion;

	/** The director. */
	@Basic
	@Column(name = "DIRECTOR")
	private String director;

	/** The distribuidora. */
	@Basic
	@Column(name = "DISTRIBUIDORA")
	private String distribuidora;

	/** The duracion. */
	@Basic
	@Column(name = "DURACION")
	private Integer duracion;

	/** The fecha estreno. */
	@Basic
	@Column(name = "FECHA_ESTRENO")
	private Date fechaEstreno;

	/** The formato. */
	@Basic
	@Column(name = "FORMATO")
	private Formato formato;

	/** The genero. */
	@Basic
	@Column(name = "GENERO")
	private Genero genero;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PELICULA")
	private Integer id;

	/** The interpretes. */
	@Basic
	@Column(name = "INTERPRETES")
	private String interpretes;

	/** The nacionalidad. */
	@Basic
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	/** The sinopsis. */
	@Basic
	@Column(name = "SINOPSIS")
	private String sinopsis;

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
		Pelicula other = (Pelicula) obj;
		if (calificacion != other.calificacion)
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (distribuidora == null) {
			if (other.distribuidora != null)
				return false;
		} else if (!distribuidora.equals(other.distribuidora))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (fechaEstreno == null) {
			if (other.fechaEstreno != null)
				return false;
		} else if (!fechaEstreno.equals(other.fechaEstreno))
			return false;
		if (formato != other.formato)
			return false;
		if (genero != other.genero)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interpretes == null) {
			if (other.interpretes != null)
				return false;
		} else if (!interpretes.equals(other.interpretes))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (sinopsis == null) {
			if (other.sinopsis != null)
				return false;
		} else if (!sinopsis.equals(other.sinopsis))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/**
	 * Gets the calificacion.
	 * 
	 * @return the calificacion
	 */
	public Calificacion getCalificacion() {
		return calificacion;
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
	 * Gets the duracion.
	 * 
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}

	/**
	 * Gets the fecha estreno.
	 * 
	 * @return the fecha estreno
	 */
	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	/**
	 * Gets the formato.
	 * 
	 * @return the formato
	 */
	public Formato getFormato() {
		return formato;
	}

	/**
	 * Gets the genero.
	 * 
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
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
	 * Gets the interpretes.
	 * 
	 * @return the interpretes
	 */
	public String getInterpretes() {
		return interpretes;
	}

	/**
	 * Gets the nacionalidad.
	 * 
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Gets the sinopsis.
	 * 
	 * @return the sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
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
		result = prime * result
				+ ((calificacion == null) ? 0 : calificacion.hashCode());
		result = prime * result
				+ ((director == null) ? 0 : director.hashCode());
		result = prime * result
				+ ((distribuidora == null) ? 0 : distribuidora.hashCode());
		result = prime * result
				+ ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result
				+ ((fechaEstreno == null) ? 0 : fechaEstreno.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((interpretes == null) ? 0 : interpretes.hashCode());
		result = prime * result
				+ ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result
				+ ((sinopsis == null) ? 0 : sinopsis.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * Sets the calificacion.
	 * 
	 * @param calificacion
	 *            the new calificacion
	 */
	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
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
	 * Sets the duracion.
	 * 
	 * @param duracion
	 *            the new duracion
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	/**
	 * Sets the fecha estreno.
	 * 
	 * @param fechaEstreno
	 *            the new fecha estreno
	 */
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	/**
	 * Sets the formato.
	 * 
	 * @param formato
	 *            the new formato
	 */
	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	/**
	 * Sets the genero.
	 * 
	 * @param genero
	 *            the new genero
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
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
	 * Sets the interpretes.
	 * 
	 * @param interpretes
	 *            the new interpretes
	 */
	public void setInterpretes(String interpretes) {
		this.interpretes = interpretes;
	}

	/**
	 * Sets the nacionalidad.
	 * 
	 * @param nacionalidad
	 *            the new nacionalidad
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Sets the sinopsis.
	 * 
	 * @param sinopsis
	 *            the new sinopsis
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
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
