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

	/** The titulo. */
	@Basic
	@Column(name = "TITULO")
	private String titulo;

	/** The director. */
	@Basic
	@Column(name = "DIRECTOR")
	private String director;

	/** The nacionalidad. */
	@Basic
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;

	/** The genero. */
	@Basic
	@Column(name = "GENERO")
	private Genero genero;

	/** The fecha estreno. */
	@Basic
	@Column(name = "FECHA_ESTRENO")
	private Date fechaEstreno;

	/** The interpretes. */
	@Basic
	@Column(name = "INTERPRETES")
	private String interpretes;

	/** The distribuidora. */
	@Basic
	@Column(name = "DISTRIBUIDORA")
	private String distribuidora;

	/** The sinopsis. */
	@Basic
	@Column(name = "SINOPSIS")
	private String sinopsis;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PELICULA")
	private Integer id;

	/** The duracion. */
	@Basic
	@Column(name = "DURACION")
	private Integer duracion;

	/**
	 * Gets the calificacion.
	 * 
	 * @return the calificacion
	 */
	public Calificacion getCalificacion() {
		return calificacion;
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
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
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

	/**
	 * Gets the director.
	 * 
	 * @return the director
	 */
	public String getDirector() {
		return director;
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
	 * Gets the nacionalidad.
	 * 
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
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
	 * Gets the genero.
	 * 
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
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
	 * Gets the fecha estreno.
	 * 
	 * @return the fecha estreno
	 */
	public Date getFechaEstreno() {
		return fechaEstreno;
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
	 * Gets the interpretes.
	 * 
	 * @return the interpretes
	 */
	public String getInterpretes() {
		return interpretes;
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
	 * Gets the distribuidora.
	 * 
	 * @return the distribuidora
	 */
	public String getDistribuidora() {
		return distribuidora;
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
	 * Gets the sinopsis.
	 * 
	 * @return the sinopsis
	 */
	public String getSinopsis() {
		return sinopsis;
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
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the duracion.
	 * 
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
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

}
