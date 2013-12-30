package com.hsl.library.controller.dto.util.impl;

import org.springframework.stereotype.Component;

import com.hsl.library.controller.dto.UsuarioDTO;
import com.hsl.library.controller.dto.util.IUsuarioUtilDTO;
import com.hsl.library.model.bean.Rol;
import com.hsl.library.model.bean.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
class UsuarioUtilDTO implements IUsuarioUtilDTO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toBusiness(com
	 * .upsam.apuestas.controller.dto.UsuarioDTO)
	 */
	@Override
	public Usuario toBusiness(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellidos(usuarioDTO.getApellidos());
		if (usuarioDTO.getRol().equals(Rol.ROLE_ADMIN.getNameId())) {
			usuario.setRol(Rol.ROLE_ADMIN);
		} else if (usuarioDTO.getRol().equals(Rol.ROLE_USER.getNameId())) {
			usuario.setRol(Rol.ROLE_USER);
		}
		usuario.setUser(usuarioDTO.getUser());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setPassword(usuarioDTO.getPassword());
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Usuario)
	 */
	@Override
	public UsuarioDTO toRest(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setRol(usuario.getRol().getNameId());
		usuarioDTO.setUser(usuario.getUser());
		usuarioDTO.setPassword(usuario.getPassword());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}
}
