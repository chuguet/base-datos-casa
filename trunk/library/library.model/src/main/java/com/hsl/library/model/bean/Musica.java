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
 * The Class Musica.
 */
@Entity
@Table(name = "MUSICA")
public class Musica implements IModelTable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4885124813162575820L;

	/** The anno publicacion. */
	@Basic
	@Column(name = "ANNO_PUBLICACION")
	private Date annoPublicacion;

	/** The artista. */
	@Basic
	@Column(name = "ARTISTA")
	private String artista;

	/** The discografica. */
	@Basic
	@Column(name = "DISCOGRAFICA")
	private String discografica;

	/** The duracion. */
	@Basic
	@Column(name = "DURACION")
	private String duracion;

	/** The genero. */
	@Basic
	@Column(name = "GENERO")
	private String genero;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MUSICA")
	private Integer id;

	/** The pais. */
	@Basic
	@Column(name = "PAIS")
	private String pais;

	/** The pistas. */
	@Basic
	@Column(name = "PISTAS")
	private Integer pistas;

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
		Musica other = (Musica) obj;
		if (annoPublicacion == null) {
			if (other.annoPublicacion != null)
				return false;
		} else if (!annoPublicacion.equals(other.annoPublicacion))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (discografica == null) {
			if (other.discografica != null)
				return false;
		} else if (!discografica.equals(other.discografica))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/**
	 * Gets the anno publicacion.
	 * 
	 * @return the anno publicacion
	 */
	public Date getAnnoPublicacion() {
		return annoPublicacion;
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
	 * Gets the discografica.
	 * 
	 * @return the discografica
	 */
	public String getDiscografica() {
		return discografica;
	}

	/**
	 * Gets the duracion.
	 * 
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
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
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the pais.
	 * 
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Gets the pistas.
	 * 
	 * @return the pistas
	 */
	public Integer getPistas() {
		return pistas;
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
				+ ((annoPublicacion == null) ? 0 : annoPublicacion.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result
				+ ((discografica == null) ? 0 : discografica.hashCode());
		result = prime * result
				+ ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/**
	 * Sets the anno publicacion.
	 * 
	 * @param annoPublicacion
	 *            the new anno publicacion
	 */
	public void setAnnoPublicacion(Date annoPublicacion) {
		this.annoPublicacion = annoPublicacion;
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
	 * Sets the discografica.
	 * 
	 * @param discografica
	 *            the new discografica
	 */
	public void setDiscografica(String discografica) {
		this.discografica = discografica;
	}

	/**
	 * Sets the duracion.
	 * 
	 * @param duracion
	 *            the new duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the pais.
	 * 
	 * @param pais
	 *            the new pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Sets the pistas.
	 * 
	 * @param pistas
	 *            the new pistas
	 */
	public void setPistas(Integer pistas) {
		this.pistas = pistas;
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
