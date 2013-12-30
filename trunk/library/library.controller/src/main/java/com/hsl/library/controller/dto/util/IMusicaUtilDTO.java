package com.hsl.library.controller.dto.util;

import java.text.ParseException;

import com.hsl.library.controller.dto.MusicaDTO;
import com.hsl.library.model.bean.Musica;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMusicaUtilDTO.
 */
public interface IMusicaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param musicaDTO
	 *            the musica dto
	 * @return the musica
	 * @throws ParseException
	 *             the parse exception
	 */
	Musica toBusiness(MusicaDTO musicaDTO) throws ParseException;

	/**
	 * To rest.
	 * 
	 * @param musica
	 *            the musica
	 * @return the musica dto
	 */
	MusicaDTO toRest(Musica musica);
}
