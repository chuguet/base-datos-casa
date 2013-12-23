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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsl.library.controller.dto.MensajeDTO;
import com.hsl.library.controller.dto.PeliculaDTO;
import com.hsl.library.controller.dto.util.IPeliculaUtilDTO;
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
		if (!operacion.equals("list")) {
			operacion = "form";
		}
		return new StringBuffer("pelicula/").append(operacion).toString();
	}
	
	@RequestMapping(value = "/generos", method = RequestMethod.GET)
	public @ResponseBody List<String> getGeneros() {
		List<String> result = new ArrayList<String>();
		for(Genero genero : Genero.values()){
			result.add(genero.getGenero());
		}
		return result;
	}

//	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
//	public @ResponseBody
//	List<PeliculaDTO> listAllFilter(
//			@RequestParam(value = "nombre") String nombre,
//			@RequestParam(value = "apellidos") String apellidos) {
//		List<PeliculaDTO> result = new ArrayList<PeliculaDTO>();
//		try {
//			BusquedaDTO busquedaDTO = new BusquedaDTO(nombre, apellidos);
//			List<Pelicula> Peliculas;
//			Peliculas = this.peliculaService.findAll();
//			if (busquedaDTO.isEmpty()) {
//				for (Pelicula Pelicula : Peliculas) {
//					PeliculaDTO PeliculaDTO = new PeliculaDTO();
//					PeliculaDTO = this.peliculaUtilDTO.toRest(Pelicula);
//					result.add(PeliculaDTO);
//				}
//			} else {
//				List<Pelicula> PeliculasFiltrados = filtrarPeliculas(Peliculas,
//						busquedaDTO);
//				for (Pelicula Pelicula : PeliculasFiltrados) {
//					PeliculaDTO porraDTO = new PeliculaDTO();
//					porraDTO = this.peliculaUtilDTO.toRest(Pelicula);
//					result.add(porraDTO);
//				}
//			}
//		} catch (DatabaseRetrieveException e) {
//			LOG.error(e.getMessage());
//		}
//		return result;
//	}
//
//	private List<Pelicula> filtrarPeliculas(List<Pelicula> Peliculas,
//			BusquedaDTO busqueda) {
//		List<Pelicula> result = new ArrayList<Pelicula>();
//		for (Pelicula Pelicula : Peliculas) {
//			if (Pelicula.getNombre().toUpperCase()
//					.contains(busqueda.getNombre().toUpperCase())
//					&& Pelicula.getApellidos().toUpperCase()
//							.contains(busqueda.getApellidos().toUpperCase())
//					&& !result.contains(Pelicula)) {
//				result.add(Pelicula);
//			}
//		}
//		return result;
//	}

	/**
	 * Insert.
	 * 
	 * @param PeliculaDTO
	 *            the Pelicula dto
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
	 * @param PeliculaDTO
	 *            the Pelicula dto
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
