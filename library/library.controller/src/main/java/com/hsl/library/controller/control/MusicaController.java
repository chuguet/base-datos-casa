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

import com.hsl.library.controller.dto.BusquedaMusicaDTO;
import com.hsl.library.controller.dto.MensajeDTO;
import com.hsl.library.controller.dto.MusicaDTO;
import com.hsl.library.controller.dto.util.IMusicaUtilDTO;
import com.hsl.library.model.bean.Musica;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.service.IMusicaService;

// TODO: Auto-generated Javadoc
/**
 * The Class MusicaController.
 */
@Controller
@RequestMapping("/musica")
public class MusicaController extends AbstractUtilController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(MusicaController.class);

	/** The musica service. */
	@Inject
	private IMusicaService musicaService;

	/** The musica util dto. */
	@Inject
	private IMusicaUtilDTO musicaUtilDTO;

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
		return new StringBuffer("musica/").append(operacion).toString();
	}

	/**
	 * Filtrar musicas.
	 * 
	 * @param musicas
	 *            the musicas
	 * @param busqueda
	 *            the busqueda
	 * @return the list
	 */
	private List<Musica> filtrarMusicas(List<Musica> musicas,
			BusquedaMusicaDTO busqueda) {
		List<Musica> result = new ArrayList<Musica>();
		for (Musica musica : musicas) {
			if (musicasSimilares(musica, busqueda) && !result.contains(musica)) {
				result.add(musica);
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
	 * Gets the paises.
	 * 
	 * @return the paises
	 */
	@RequestMapping(value = "/paises", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getPaises() {
		List<String> result = new ArrayList<String>();
		String[] countries = Locale.getISOCountries();

		for (String country : countries) {
			Locale locale = new Locale("", country);
			result.add(locale.getDisplayName());
		}
		Collections.sort(result);
		return result;
	}

	/**
	 * Insert.
	 * 
	 * @param musicaDTO
	 *            the musica dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody MusicaDTO musicaDTO) {
		if (musicaDTO == null) {
			return new MensajeDTO("Una musica es requerida", false);
		}
		try {
			Musica musica = musicaUtilDTO.toBusiness(musicaDTO);
			musicaService.save(musica);
			return new MensajeDTO("Musica creada correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer("Ya existe la musica ")
					.append(musicaDTO.getTitulo()).append(" en base de datos.")
					.toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error al introducir la musica.", false);
		}
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<MusicaDTO> listAll() {
		List<MusicaDTO> musicasDTO = new ArrayList<MusicaDTO>();

		try {
			List<Musica> musicas = this.musicaService.findAll();

			for (Musica musica : musicas) {
				MusicaDTO musicaDTO = musicaUtilDTO.toRest(musica);
				musicasDTO.add(musicaDTO);
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return musicasDTO;
	}

	/**
	 * List all filter.
	 * 
	 * @param titulo
	 *            the titulo
	 * @param artista
	 *            the artista
	 * @param decada
	 *            the decada
	 * @return the list
	 */
	@RequestMapping(value = "/busqueda", method = RequestMethod.GET)
	public @ResponseBody
	List<MusicaDTO> listAllFilter(
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "artista") String artista,
			@RequestParam(value = "decada") String decada) {
		List<MusicaDTO> result = new ArrayList<MusicaDTO>();
		try {
			BusquedaMusicaDTO busquedaDTO = new BusquedaMusicaDTO(titulo,
					artista, decada);
			List<Musica> musicas = this.musicaService.findAll();
			if (busquedaDTO.isEmpty()) {
				for (Musica musica : musicas) {
					MusicaDTO musicaDTO = new MusicaDTO();
					musicaDTO = this.musicaUtilDTO.toRest(musica);
					result.add(musicaDTO);
				}
			} else {
				List<Musica> musicasFiltrados = filtrarMusicas(musicas,
						busquedaDTO);
				for (Musica musica : musicasFiltrados) {
					MusicaDTO musicaDTO = new MusicaDTO();
					musicaDTO = this.musicaUtilDTO.toRest(musica);
					result.add(musicaDTO);
				}
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Musicas similares.
	 * 
	 * @param musica
	 *            the musica
	 * @param busqueda
	 *            the busqueda
	 * @return the boolean
	 */
	private Boolean musicasSimilares(Musica musica, BusquedaMusicaDTO busqueda) {
		return musica.getTitulo().toUpperCase()
				.contains(busqueda.getTitulo().toUpperCase())
				&& musica.getArtista().toUpperCase()
						.contains(busqueda.getArtista().toUpperCase())
				&& estaEnDecada(musica.getAnnoPublicacion(),
						busqueda.getDecada());
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
			return new MensajeDTO("Una musica es requerida", false);
		}
		try {
			Musica musica = new Musica();
			musica.setId(id);
			this.musicaService.delete(musica);
			return new MensajeDTO("Musica eliminada correctamente", true);
		} catch (DatabaseDeleteException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("La musica no ha podido ser borrada", false);
		}
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the musica dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	MusicaDTO retrieve(@PathVariable("id") Integer id) {
		MusicaDTO musicaDTO = new MusicaDTO();
		try {
			Musica musica = this.musicaService.findOne(id);
			musicaDTO = musicaUtilDTO.toRest(musica);
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
			LOG.error(new StringBuffer(
					"No ha podido recuperarse la musica con id ").append(id)
					.toString());
		}
		return musicaDTO;
	}

	/**
	 * Update.
	 * 
	 * @param musicaDTO
	 *            the musica dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody MusicaDTO musicaDTO) {
		if (musicaDTO == null) {
			return new MensajeDTO("Una musica es requerida", false);
		}
		try {
			Musica musica = musicaUtilDTO.toBusiness(musicaDTO);
			musicaService.update(musica);
			return new MensajeDTO("Musica modificada correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer(
					"No se ha podido actualizar la musica ")
					.append(musicaDTO.getTitulo()).append(" en base de datos.")
					.toString(), false);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("Error de conversión de la fecha.", false);
		}
	}
}
