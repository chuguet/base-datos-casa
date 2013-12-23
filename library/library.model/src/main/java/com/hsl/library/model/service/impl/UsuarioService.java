package com.hsl.library.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hsl.library.model.bean.Usuario;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.repository.IUsuarioRepository;
import com.hsl.library.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service
class UsuarioService implements IUsuarioService {

	private static final Log LOG = LogFactory.getLog(UsuarioService.class);

	/** The usuario repository. */
	@Inject
	private IUsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public void delete(Usuario usuario) throws DatabaseDeleteException {
		try {
			usuarioRepository.delete(usuario);
			LOG.debug(new StringBuffer("Se ha borrado el usuario con id: ")
					.append(usuario.getId()).toString());
		} catch (SQLException e) {
			LOG.error("Error al borrar un usuario de base de datos.");
			throw new DatabaseDeleteException(e.getMessage(), e);
		}
	}

	/**
	 * Encript user.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	private Usuario encriptUser(Usuario usuario) {
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pwd = passwordEncoder
				.encodePassword(usuario.getPassword(), null);
		usuario.setPassword(pwd);
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.apuestas.model.service.IModelService#findAll()
	 */
	public List<Usuario> findAll() throws DatabaseRetrieveException {
		try {
			List<Usuario> result = usuarioRepository.findAll();
			LOG.debug(new StringBuffer("Se han recuperado ")
					.append(result.size()).append(" usuarios.").toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al recuperar todos los usuarios de base de datos.");
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#findOne(java.lang.Integer)
	 */
	public Usuario findOne(Integer pId) throws DatabaseRetrieveException {
		try {
			Usuario result = usuarioRepository.findOne(pId);
			LOG.debug(new StringBuffer("Se ha recuperado el usuario: ").append(
					result.getNombre()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error(new StringBuffer("Error al recuperar el usuario con id: ")
					.append(pId).toString());
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public Integer save(Usuario usuario) throws DatabaseInsertException {
		try {
			Integer result = usuarioRepository.save(usuario);
			LOG.debug(new StringBuffer(
					"Se ha guardado en base de datos el usuario: ").append(
					usuario.getNombre()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al insertar el usuario en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IUsuarioService#selectByUser(java.lang
	 * .String)
	 */
	public Usuario selectByUser(String user) throws DatabaseRetrieveException {
		try {
			Usuario usuario = usuarioRepository.selectByUser(user);
			LOG.debug(new StringBuffer(
					"Se ha recuperado de base de datos el usuario: ").append(
					usuario.getNombre()).toString());
			return usuario;
		} catch (SQLException e) {
			LOG.error(new StringBuffer("Error al recuperar el usuario ")
					.append(user).append(" de base de datos.").toString());
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	public void update(Usuario usuario) throws DatabaseInsertException {
		try {
			usuarioRepository.update(encriptUser(usuario));
			LOG.debug(new StringBuffer("Se ha actualizado el usuario: ")
					.append(usuario.getNombre()).toString());
		} catch (SQLException e) {
			LOG.error("Error al actualizar el usuario en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

}
