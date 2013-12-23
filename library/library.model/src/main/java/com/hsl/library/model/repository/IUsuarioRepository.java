package com.hsl.library.model.repository;

import java.sql.SQLException;

import com.hsl.library.model.bean.Usuario;

/**
 * The Interface IUsuarioRepository.
 */
public interface IUsuarioRepository extends IRepositoryDAO<Usuario> {

	/**
	 * Select by user.
	 * 
	 * @param user
	 *            the user
	 * @return the usuario
	 * @throws SQLException
	 *             the sql exception
	 */
	Usuario selectByUser(String user) throws SQLException;
}
