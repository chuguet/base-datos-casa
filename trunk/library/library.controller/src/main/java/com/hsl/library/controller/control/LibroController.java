package com.hsl.library.controller.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsl.library.controller.dto.BusquedaLibroDTO;
import com.hsl.library.controller.dto.LibroDTO;
import com.hsl.library.controller.dto.MensajeDTO;
import com.hsl.library.controller.dto.util.ILibroUtilDTO;
import com.hsl.library.model.bean.Libro;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.service.ILibroService;

// TODO: Auto-generated Javadoc
/**
 * The Class LibroController.
 */
@Controller
@RequestMapping("/libro")
public class LibroController extends AbstractUtilController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(LibroController.class);

	/** The libro service. */
	@Inject
	private ILibroService libroService;

	/** The libro util dto. */
	@Inject
	private ILibroUtilDTO libroUtilDTO;

	/**
	 * Creates the form.
	 * 
	 * @param operacion
	 *            the operacion
	 * @param uiModel
	 *            the ui model
	 * @return the string
	 */
	@RequestMapping(value = "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion,
			final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list") && !operacion.equals("detail")) {
			operacion = "form";
		}
		return new StringBuffer("libro/").append(operacion).toString();
	}

	/**
	 * Filtrar libros.
	 * 
	 * @param libros
	 *            the libros
	 * @param busqueda
	 *            the busqueda
	 * @return the list
	 */
	private List<Libro> filtrarLibros(List<Libro> libros,
			BusquedaLibroDTO busqueda) {
		List<Libro> result = new ArrayList<Libro>();
		for (Libro libro : libros) {
			if (librosSimilares(libro, busqueda) && !result.contains(libro)) {
				result.add(libro);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.controller.control.AbstractUtilController#getDecadas()
	 */
	@RequestMapping(value = "/decadas", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getDecadas() {
		return super.getDecadas();
	}

	/**
	 * Gets the lenguajes.
	 * 
	 * @return the lenguajes
	 */
	@RequestMapping(value = "/lenguajes", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getLenguajes() {
		List<String> result = new ArrayList<String>();
		String[] languages = Locale.getISOLanguages();

		for (String language : languages) {
			Locale locale = new Locale(language);
			result.add(new StringBuffer(locale.getDisplayLanguage()
					.substring(0, 1).toUpperCase()).append(
					locale.getDisplayLanguage().substring(1)).toString());
		}
		Collections.sort(result);
		return result;
	}

	/**
	 * Insert.
	 * 
	 * @param libroDTO
	 *            the libro dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody LibroDTO libroDTO) {
		if (libroDTO == null) {
			return new MensajeDTO("Un libro es requerido", false);
		}
		try {
			Libro libro = libroUtilDTO.toBusiness(libroDTO);
			libroService.save(libro);
			return new MensajeDTO("Libro creado correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer("Ya existe el libro ")
					.append(libroDTO.getTitulo()).append(" en base de datos.")
					.toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error al introducir la fecha.", false);
		}
	}

	/**
	 * Libros similares.
	 * 
	 * @param libro
	 *            the libro
	 * @param busqueda
	 *            the busqueda
	 * @return the boolean
	 */
	private Boolean librosSimilares(Libro libro, BusquedaLibroDTO busqueda) {
		return libro.getTitulo().toUpperCase()
				.contains(busqueda.getTitulo().toUpperCase())
				&& libro.getAutores().toUpperCase()
						.contains(busqueda.getAutores().toUpperCase())
				&& estaEnDecada(libro.getFechaEdicion(), busqueda.getDecada());
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<LibroDTO> listAll() {
		List<LibroDTO> librosDTO = new ArrayList<LibroDTO>();

		try {
			List<Libro> libros = this.libroService.findAll();

			for (Libro libro : libros) {
				LibroDTO libroDTO = libroUtilDTO.toRest(libro);
				librosDTO.add(libroDTO);
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return librosDTO;
	}

	/**
	 * List all filter.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param autores
	 *            the autores
	 * @param decada
	 *            the decada
	 * @return the list
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
	public @ResponseBody
	List<LibroDTO> listAllFilter(@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "autores") String autores,
			@RequestParam(value = "decada") String decada) {
		List<LibroDTO> result = new ArrayList<LibroDTO>();
		try {
			BusquedaLibroDTO busquedaDTO = new BusquedaLibroDTO(titulo,
					autores, decada);
			List<Libro> libros = this.libroService.findAll();
			if (busquedaDTO.isEmpty()) {
				for (Libro libro : libros) {
					LibroDTO libroDTO = new LibroDTO();
					libroDTO = this.libroUtilDTO.toRest(libro);
					result.add(libroDTO);
				}
			} else {
				List<Libro> librosFiltrados = filtrarLibros(libros, busquedaDTO);
				for (Libro libro : librosFiltrados) {
					LibroDTO libroDTO = new LibroDTO();
					libroDTO = this.libroUtilDTO.toRest(libro);
					result.add(libroDTO);
				}
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Removes the.
	 * 
	 * @param id
	 *            the id
	 * @param uiModel
	 *            the ui model
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		if (id == null) {
			return new MensajeDTO("Un libro es requerido", false);
		}
		try {
			Libro libro = new Libro();
			libro.setId(id);
			this.libroService.delete(libro);
			return new MensajeDTO("Libro eliminado correctamente", true);
		} catch (DatabaseDeleteException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("El libro no ha podido ser borrado", false);
		}
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the libro dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	LibroDTO retrieve(@PathVariable("id") Integer id) {
		LibroDTO libroDTO = new LibroDTO();
		try {
			Libro libro = this.libroService.findOne(id);
			libroDTO = libroUtilDTO.toRest(libro);
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
			LOG.error(new StringBuffer(
					"No ha podido recuperarse el libro con id ").append(id)
					.toString());
		}
		return libroDTO;
	}

	/**
	 * Update.
	 * 
	 * @param libroDTO
	 *            the libro dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody LibroDTO libroDTO) {
		if (libroDTO == null) {
			return new MensajeDTO("Un libro es requerido", false);
		}
		try {
			Libro libro = libroUtilDTO.toBusiness(libroDTO);
			libroService.update(libro);
			return new MensajeDTO("Libro modificado correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer(
					"No se ha podido actualizar el libro ")
					.append(libroDTO.getTitulo()).append(" en base de datos.")
					.toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error de conversión de la fecha.", false);
		}
	}

}
