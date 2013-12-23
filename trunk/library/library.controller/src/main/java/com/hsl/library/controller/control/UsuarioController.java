package com.hsl.library.controller.control;

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
import com.hsl.library.controller.dto.UsuarioDTO;
import com.hsl.library.controller.dto.util.IUsuarioUtilDTO;
import com.hsl.library.model.bean.Usuario;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioController.
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(UsuarioController.class);

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

	/** The usuario util dto. */
	@Inject
	private IUsuarioUtilDTO usuarioUtilDTO;

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
		return new StringBuffer("usuario/").append(operacion).toString();
	}

	/**
	 * Insert the user.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = usuarioUtilDTO.toBusiness(usuarioDTO);
			usuarioService.save(usuario);
			return new MensajeDTO("Usuario creado correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer("Ya existe el usuario ")
					.append(usuarioDTO.getUser()).append(" en base de datos.")
					.toString(), false);
		}
	}

	/**
	 * List all users.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<UsuarioDTO> listAll() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

		try {
			List<Usuario> usuarios = this.usuarioService.findAll();

			for (Usuario usuario : usuarios) {
				UsuarioDTO usuarioDTO = usuarioUtilDTO.toRest(usuario);
				usuariosDTO.add(usuarioDTO);
			}
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return usuariosDTO;
	}

	/**
	 * Removes the user by id.
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
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			this.usuarioService.delete(usuario);
			return new MensajeDTO("Usuario eliminado correctamente", true);
		} catch (DatabaseDeleteException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO("El usuario no ha podido ser borrado", false);
		}
	}

	/**
	 * Retrieve one User.
	 * 
	 * @param id
	 *            the id
	 * @return the usuario dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	UsuarioDTO retrieve(@PathVariable("id") Integer id) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		try {
			Usuario usuario = this.usuarioService.findOne(id);
			usuarioDTO = usuarioUtilDTO.toRest(usuario);
		} catch (DatabaseRetrieveException e) {
			LOG.error(e.getMessage());
		}
		return usuarioDTO;
	}

	/**
	 * Update the user.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = usuarioUtilDTO.toBusiness(usuarioDTO);
			usuarioService.update(usuario);
			return new MensajeDTO("Usuario modificado correctamente", true);
		} catch (DatabaseInsertException e) {
			LOG.error(e.getMessage());
			return new MensajeDTO(new StringBuffer(
					"No se ha podido actualizar el usuario ")
					.append(usuarioDTO.getUser()).append(" en base de datos.")
					.toString(), false);
		}
	}
}
