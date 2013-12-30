package com.hsl.library.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.hsl.library.controller.dto.MusicaDTO;
import com.hsl.library.controller.dto.util.IMusicaUtilDTO;
import com.hsl.library.model.bean.Musica;

// TODO: Auto-generated Javadoc
/**
 * The Class MusicaUtilDTO.
 */
@Component
class MusicaUtilDTO implements IMusicaUtilDTO {

	/** The date formatter. */
	private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.IMusicaUtilDTO#toBusiness(com.hsl
	 * .library.controller.dto.MusicaDTO)
	 */
	@Override
	public Musica toBusiness(MusicaDTO musicaDTO) throws ParseException {
		Musica musica = new Musica();
		musica.setAnnoPublicacion(DATE_FORMATTER.parse(musicaDTO
				.getAnnoPublicacion()));
		musica.setArtista(musicaDTO.getArtista());
		musica.setDiscografica(musicaDTO.getDiscografica());
		musica.setDuracion(musicaDTO.getDuracion());
		musica.setGenero(musicaDTO.getGenero());
		musica.setPistas(musicaDTO.getPistas());
		musica.setId(musicaDTO.getId());
		musica.setPais(musicaDTO.getPais());
		musica.setTitulo(musicaDTO.getTitulo());
		return musica;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.IMusicaUtilDTO#toRest(com.hsl.library
	 * .model.bean.Musica)
	 */
	@Override
	public MusicaDTO toRest(Musica musica) {
		MusicaDTO musicaDTO = new MusicaDTO();
		musicaDTO.setAnnoPublicacion(DATE_FORMATTER.format(musica
				.getAnnoPublicacion()));
		musicaDTO.setArtista(musica.getArtista());
		musicaDTO.setDiscografica(musica.getDiscografica());
		musicaDTO.setDuracion(musica.getDuracion());
		musicaDTO.setGenero(musica.getGenero());
		musicaDTO.setPistas(musica.getPistas());
		musicaDTO.setId(musica.getId());
		musicaDTO.setPais(musica.getPais());
		musicaDTO.setTitulo(musica.getTitulo());
		return musicaDTO;
	}

}
