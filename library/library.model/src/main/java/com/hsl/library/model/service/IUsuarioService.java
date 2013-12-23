package com.hsl.library.model.service;

import com.hsl.library.model.bean.Usuario;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseRetrieveException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService extends IModelService<Usuario> {

	/**
	 * Select by user.
	 * 
	 * @param user
	 *            the user
	 * @return the usuario
	 * @throws DatabaseDeleteException
	 *             the app exception
	 */
	Usuario selectByUser(String user) throws DatabaseRetrieveException;
}
