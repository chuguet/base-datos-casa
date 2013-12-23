package com.hsl.library.controller.dto.util;

import java.text.ParseException;

import com.hsl.library.controller.dto.PeliculaDTO;
import com.hsl.library.model.bean.Pelicula;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPeliculaUtilDTO.
 */
public interface IPeliculaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param peliculaDTO
	 *            the pelicula dto
	 * @return the pelicula
	 * @throws ParseException
	 *             the parse exception
	 */
	Pelicula toBusiness(PeliculaDTO peliculaDTO) throws ParseException;

	/**
	 * To rest.
	 * 
	 * @param pelicula
	 *            the pelicula
	 * @return the pelicula dto
	 */
	PeliculaDTO toRest(Pelicula pelicula);
}
