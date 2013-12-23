package com.hsl.library.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.hsl.library.controller.dto.PeliculaDTO;
import com.hsl.library.controller.dto.util.IPeliculaUtilDTO;
import com.hsl.library.model.bean.Calificacion;
import com.hsl.library.model.bean.Formato;
import com.hsl.library.model.bean.Genero;
import com.hsl.library.model.bean.Pelicula;

// TODO: Auto-generated Javadoc
/**
 * The Class PeliculaUtilDTO.
 */
@Component
public class PeliculaUtilDTO implements IPeliculaUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.IPeliculaUtilDTO#toBusiness(com.hsl
	 * .library.controller.dto.PeliculaDTO)
	 */
	@Override
	public Pelicula toBusiness(PeliculaDTO peliculaDTO) throws ParseException {
		Pelicula pelicula = new Pelicula();
		pelicula.setCalificacion(Calificacion.valueOf(peliculaDTO
				.getCalificacion()));
		pelicula.setDirector(peliculaDTO.getDirector());
		pelicula.setDistribuidora(peliculaDTO.getDistribuidora());
		pelicula.setDuracion(peliculaDTO.getDuracion());
		pelicula.setFechaEstreno(DATE_FORMATTER.parse(peliculaDTO
				.getFechaEstreno()));
		pelicula.setGenero(Genero.valueOf(peliculaDTO.getGenero()));
		pelicula.setId(peliculaDTO.getId());
		pelicula.setInterpretes(peliculaDTO.getInterpretes());
		pelicula.setNacionalidad(peliculaDTO.getNacionalidad());
		pelicula.setSinopsis(peliculaDTO.getSinopsis());
		pelicula.setTitulo(peliculaDTO.getTitulo());
		pelicula.setFormato(Formato.valueOf(peliculaDTO.getFormato()));
		return pelicula;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.IPeliculaUtilDTO#toRest(com.hsl.library
	 * .model.bean.Pelicula)
	 */
	@Override
	public PeliculaDTO toRest(Pelicula pelicula) {
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		peliculaDTO.setCalificacion(pelicula.getCalificacion().getNameId());
		peliculaDTO.setDirector(pelicula.getDirector());
		peliculaDTO.setDistribuidora(pelicula.getDistribuidora());
		peliculaDTO.setDuracion(pelicula.getDuracion());
		peliculaDTO.setFechaEstreno(DATE_FORMATTER.format(pelicula
				.getFechaEstreno()));
		peliculaDTO.setGenero(pelicula.getGenero().getGenero());
		peliculaDTO.setId(pelicula.getId());
		peliculaDTO.setInterpretes(pelicula.getInterpretes());
		peliculaDTO.setNacionalidad(pelicula.getNacionalidad());
		peliculaDTO.setSinopsis(pelicula.getSinopsis());
		peliculaDTO.setTitulo(pelicula.getTitulo());
		peliculaDTO.setFormato(pelicula.getFormato().getFormato());
		return peliculaDTO;
	}

}
