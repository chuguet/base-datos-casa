package com.hsl.library.controller.dto.util;

import com.hsl.library.controller.dto.UsuarioDTO;
import com.hsl.library.model.bean.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioUtilDTO.
 */
public interface IUsuarioUtilDTO {

	/**
	 * To business.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the usuario
	 */
	Usuario toBusiness(UsuarioDTO usuarioDTO);

	/**
	 * To rest.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario dto
	 */
	UsuarioDTO toRest(Usuario usuario);

}
