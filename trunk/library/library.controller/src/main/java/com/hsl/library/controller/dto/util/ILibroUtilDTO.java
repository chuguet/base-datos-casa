package com.hsl.library.controller.dto.util;

import java.text.ParseException;

import com.hsl.library.controller.dto.LibroDTO;
import com.hsl.library.model.bean.Libro;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILibroUtilDTO.
 */
public interface ILibroUtilDTO {

	/**
	 * To business.
	 * 
	 * @param libroDTO
	 *            the libro dto
	 * @return the libro
	 * @throws ParseException
	 *             the parse exception
	 */
	Libro toBusiness(LibroDTO libroDTO) throws ParseException;

	/**
	 * To rest.
	 * 
	 * @param libro
	 *            the libro
	 * @return the libro dto
	 */
	LibroDTO toRest(Libro libro);
}
