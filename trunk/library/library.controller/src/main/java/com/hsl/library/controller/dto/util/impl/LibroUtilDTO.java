package com.hsl.library.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.hsl.library.controller.dto.LibroDTO;
import com.hsl.library.controller.dto.util.ILibroUtilDTO;
import com.hsl.library.model.bean.Libro;

// TODO: Auto-generated Javadoc
/**
 * The Class LibroUtilDTO.
 */
@Component
public class LibroUtilDTO implements ILibroUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"MM/yyyy");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.ILibroUtilDTO#toBusiness(com.hsl.
	 * library.controller.dto.LibroDTO)
	 */
	@Override
	public Libro toBusiness(LibroDTO libroDTO) throws ParseException {
		Libro libro = new Libro();
		libro.setAutores(libroDTO.getAutores());
		libro.setColeccion(libroDTO.getColeccion());
		libro.setDescripcion(libroDTO.getDescripcion());
		;
		libro.setEdicion(libroDTO.getEdicion());
		libro.setEncuadernacion(libroDTO.getEncuadernacion());
		libro.setFechaEdicion(DATE_FORMATTER.parse(libroDTO.getFechaEdicion()));
		libro.setFechaImpresion(DATE_FORMATTER.parse(libroDTO
				.getFechaImpresion()));
		libro.setId(libroDTO.getId());
		libro.setIsbn10(libroDTO.getIsbn10());
		libro.setIsbn13(libroDTO.getIsbn13());
		libro.setLenguaPublicacion(libroDTO.getLenguaPublicacion());
		libro.setLenguaTraduccion(libroDTO.getLenguaTraduccion());
		libro.setMaterias(libroDTO.getMaterias());
		libro.setPrecio(libroDTO.getPrecio());
		libro.setPublicacion(libroDTO.getPublicacion());
		libro.setTitulo(libroDTO.getTitulo());
		return libro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.dto.util.ILibroUtilDTO#toRest(com.hsl.library
	 * .model.bean.Libro)
	 */
	@Override
	public LibroDTO toRest(Libro libro) {
		LibroDTO libroDTO = new LibroDTO();
		libroDTO.setAutores(libro.getAutores());
		libroDTO.setColeccion(libro.getColeccion());
		libroDTO.setDescripcion(libro.getDescripcion());
		;
		libroDTO.setEdicion(libro.getEdicion());
		libroDTO.setEncuadernacion(libro.getEncuadernacion());
		libroDTO.setFechaEdicion(DATE_FORMATTER.format(libro.getFechaEdicion()));
		libroDTO.setFechaImpresion(DATE_FORMATTER.format(libro
				.getFechaImpresion()));
		libroDTO.setId(libro.getId());
		libroDTO.setIsbn10(libro.getIsbn10());
		libroDTO.setIsbn13(libro.getIsbn13());
		libroDTO.setLenguaPublicacion(libro.getLenguaPublicacion());
		libroDTO.setLenguaTraduccion(libro.getLenguaTraduccion());
		libroDTO.setMaterias(libro.getMaterias());
		libroDTO.setPrecio(libro.getPrecio());
		libroDTO.setPublicacion(libro.getPublicacion());
		libroDTO.setTitulo(libro.getTitulo());
		return libroDTO;
	}

}
