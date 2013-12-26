package com.hsl.library.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hsl.library.model.bean.Libro;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.repository.ILibroRepository;
import com.hsl.library.model.service.ILibroService;

// TODO: Auto-generated Javadoc
/**
 * The Class LibroService.
 */
@Service
class LibroService implements ILibroService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LibroService.class);

	/** The libro repository. */
	@Inject
	private ILibroRepository libroRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.service.IModelService#delete(com.hsl.library.model
	 * .bean.IModelTable)
	 */
	@Override
	public void delete(Libro libro) throws DatabaseDeleteException {
		try {
			libroRepository.delete(libro);
			LOG.debug(new StringBuffer("Se ha borrado el libro con id: ")
					.append(libro.getId()).toString());
		} catch (SQLException e) {
			LOG.error("Error al borrar el libro de base de datos.");
			throw new DatabaseDeleteException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsl.library.model.service.IModelService#findAll()
	 */
	@Override
	public List<Libro> findAll() throws DatabaseRetrieveException {
		try {
			List<Libro> result = libroRepository.findAll();
			LOG.debug(new StringBuffer("Se han recuperado ")
					.append(result.size()).append(" libros.").toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al recuperar todos los libros de base de datos.");
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public Libro findOne(Integer pId) throws DatabaseRetrieveException {
		try {
			Libro result = libroRepository.findOne(pId);
			LOG.debug(new StringBuffer("Se ha recuperado el libro: ").append(
					result.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error(new StringBuffer("Error al recuperar el libro con id: ")
					.append(pId).toString());
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.service.IModelService#save(com.hsl.library.model
	 * .bean.IModelTable)
	 */
	@Override
	public Integer save(Libro libro) throws DatabaseInsertException {
		try {
			Integer result = libroRepository.save(libro);
			LOG.debug(new StringBuffer(
					"Se ha guardado en base de datos el libro: ").append(
					libro.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al insertar el libro en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.service.IModelService#update(com.hsl.library.model
	 * .bean.IModelTable)
	 */
	@Override
	public void update(Libro libro) throws DatabaseInsertException {
		try {
			libroRepository.update(libro);
			LOG.debug(new StringBuffer("Se ha actualizado el libro: ").append(
					libro.getTitulo()).toString());
		} catch (SQLException e) {
			LOG.error("Error al actualizar el libro en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

}
