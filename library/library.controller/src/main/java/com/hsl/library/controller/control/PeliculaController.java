package com.hsl.library.controller.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

import com.hsl.library.controller.dto.BusquedaDTO;
import com.hsl.library.controller.dto.MensajeDTO;
import com.hsl.library.controller.dto.PeliculaDTO;
import com.hsl.library.controller.dto.util.IPeliculaUtilDTO;
import com.hsl.library.model.bean.Calificacion;
import com.hsl.library.model.bean.Formato;
import com.hsl.library.model.bean.Genero;
import com.hsl.library.model.bean.Pelicula;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.service.IPeliculaService;

// TODO: Auto-generated Javadoc
/**
 * The Class PeliculaController.
 */
@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(PeliculaController.class);

	/** The pelicula service. */
	@Inject
	private IPeliculaService peliculaService;

	/** The pelicula util dto. */
	@Inject
	private IPeliculaUtilDTO peliculaUtilDTO;

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
		return new StringBuffer("pelicula/").append(operacion).toString();
	}

	/**
	 * Filtrar peliculas.
	 * 
	 * @param peliculas
	 *            the peliculas
	 * @param busqueda
	 *            the busqueda
	 * @return the list
	 */
	private List<Pelicula> filtrarPeliculas(List<Pelicula> peliculas,
			BusquedaDTO busqueda) {
		List<Pelicula> result = new ArrayList<Pelicula>();
		for (Pelicula pelicula : peliculas) {
			if (peliculasSimilares(pelicula, busqueda)
					&& !result.contains(pelicula)) {
				result.add(pelicula);
			}
		}
		return result;
	}

	/**
	 * Gets the calificaciones.
	 * 
	 * @return the calificaciones
	 */
	@RequestMapping(value = "/calificaciones", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getCalificaciones() {
		List<String> result = new ArrayList<String>();
		for (Calificacion calificacion : Calificacion.values()) {
			result.add(calificacion.getNameId());
		}
		return result;
	}

	/**
	 * Gets the formatos.
	 * 
	 * @return the formatos
	 */
	@RequestMapping(value = "/formatos", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getFormatos() {
		List<String> result = new ArrayList<String>();
		for (Formato formato : Formato.values()) {
			result.add(formato.getNameId());
		}
		return result;
	}

	/**
	 * Gets the generos.
	 * 
	 * @return the generos
	 */
	@RequestMapping(value = "/generos", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getGeneros() {
		List<String> result = new ArrayList<String>();
		for (Genero genero : Genero.values()) {
			result.add(genero.getNameId());
		}
		return result;
	}

	/**
	 * Insert.
	 * 
	 * @param peliculaDTO
	 *            the pelicula dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PeliculaDTO peliculaDTO) {
		if (peliculaDTO == null) {
			return new MensajeDTO("Un Pelicula es requerido", false);
		}
		try {
			Pelicula pelicula = peliculaUtilDTO.toBusiness(peliculaDTO);
			peliculaService.save(pelicula);
			return new MensajeDTO("Pelicula creada correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer("Ya existe la pelicula ")
					.append(peliculaDTO.getTitulo())
					.append(" en base de datos.").toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error al introducir la fecha.", false);
		}
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PeliculaDTO> listAll() {
		List<PeliculaDTO> peliculasDTO = new ArrayList<PeliculaDTO>();

		try {
			List<Pelicula> Peliculas = this.peliculaService.findAll();

			for (Pelicula Pelicula : Peliculas) {
				PeliculaDTO PeliculaDTO = peliculaUtilDTO.toRest(Pelicula);
				peliculasDTO.add(PeliculaDTO);
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return peliculasDTO;
	}

	/**
	 * List all filter.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param director
	 *            the director
	 * @param interpretes
	 *            the interpretes
	 * @param distribuidora
	 *            the distribuidora
	 * @param genero
	 *            the genero
	 * @return the list
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
	public @ResponseBody
	List<PeliculaDTO> listAllFilter(
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "director") String director,
			@RequestParam(value = "interpretes") String interpretes,
			@RequestParam(value = "distribuidora") String distribuidora,
			@RequestParam(value = "genero") String genero) {
		List<PeliculaDTO> result = new ArrayList<PeliculaDTO>();
		try {
			BusquedaDTO busquedaDTO = new BusquedaDTO(titulo, director,
					interpretes, distribuidora, genero);
			List<Pelicula> peliculas;
			peliculas = this.peliculaService.findAll();
			if (busquedaDTO.isEmpty()) {
				for (Pelicula pelicula : peliculas) {
					PeliculaDTO peliculaDTO = new PeliculaDTO();
					peliculaDTO = this.peliculaUtilDTO.toRest(pelicula);
					result.add(peliculaDTO);
				}
			} else {
				List<Pelicula> peliculasFiltrados = filtrarPeliculas(peliculas,
						busquedaDTO);
				for (Pelicula pelicula : peliculasFiltrados) {
					PeliculaDTO peliculaDTO = new PeliculaDTO();
					peliculaDTO = this.peliculaUtilDTO.toRest(pelicula);
					result.add(peliculaDTO);
				}
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Peliculas similares.
	 * 
	 * @param pelicula
	 *            the pelicula
	 * @param busqueda
	 *            the busqueda
	 * @return the boolean
	 */
	private Boolean peliculasSimilares(Pelicula pelicula, BusquedaDTO busqueda) {
		return pelicula.getDirector().toUpperCase()
				.contains(busqueda.getDirector().toUpperCase())
				&& pelicula.getDistribuidora().toUpperCase()
						.contains(busqueda.getDistribuidora().toUpperCase())
				&& pelicula.getInterpretes().toUpperCase()
						.contains(busqueda.getInterpretes().toUpperCase())
				&& pelicula.getTitulo().toUpperCase()
						.contains(busqueda.getTitulo().toUpperCase())
				&& pelicula.getGenero().getNameId().toUpperCase()
						.contains(busqueda.getGenero().toUpperCase());
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
			return new MensajeDTO("Un Pelicula es requerido", false);
		}
		try {
			Pelicula pelicula = new Pelicula();
			pelicula.setId(id);
			this.peliculaService.delete(pelicula);
			return new MensajeDTO("Pelicula eliminada correctamente", true);
		} catch (DatabaseDeleteException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("La pelicula no ha podido ser borrada", false);
		}
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the Pelicula dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PeliculaDTO retrieve(@PathVariable("id") Integer id) {
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		try {
			Pelicula pelicula = this.peliculaService.findOne(id);
			peliculaDTO = peliculaUtilDTO.toRest(pelicula);
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return peliculaDTO;
	}

	/**
	 * Update.
	 * 
	 * @param peliculaDTO
	 *            the pelicula dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody PeliculaDTO peliculaDTO) {
		if (peliculaDTO == null) {
			return new MensajeDTO("Una pelicula es requerida", false);
		}
		try {
			Pelicula pelicula = peliculaUtilDTO.toBusiness(peliculaDTO);
			peliculaService.update(pelicula);
			return new MensajeDTO("Pelicula modificada correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer(
					"No se ha podido actualizar la pelicula ")
					.append(peliculaDTO.getTitulo())
					.append(" en base de datos.").toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error de conversión de la fecha.", false);
		}
	}
}
