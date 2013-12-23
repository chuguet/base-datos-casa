package com.hsl.library.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hsl.library.model.bean.Pelicula;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.repository.IPeliculaRepository;
import com.hsl.library.model.service.IPeliculaService;

@Service
class PeliculaService implements IPeliculaService {

	private static final Log LOG = LogFactory.getLog(PeliculaService.class);

	@Inject
	private IPeliculaRepository peliculaRepository;

	@Override
	public void delete(Pelicula pelicula) throws DatabaseDeleteException {
		try {
			peliculaRepository.delete(pelicula);
			LOG.debug(new StringBuffer("Se ha borrado la pelicula con id: ")
					.append(pelicula.getId()).toString());
		} catch (SQLException e) {
			LOG.error("Error al borrar la pelicula de base de datos.");
			throw new DatabaseDeleteException(e.getMessage(), e);
		}
	}

	@Override
	public List<Pelicula> findAll() throws DatabaseRetrieveException {
		try {
			List<Pelicula> result = peliculaRepository.findAll();
			LOG.debug(new StringBuffer("Se han recuperado ")
					.append(result.size()).append(" peliculas.").toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al recuperar todas las peliculas de base de datos.");
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	@Override
	public Pelicula findOne(Integer pId) throws DatabaseRetrieveException {
		try {
			Pelicula result = peliculaRepository.findOne(pId);
			LOG.debug(new StringBuffer("Se ha recuperado la pelicula: ")
					.append(result.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error(new StringBuffer(
					"Error al recuperar la pelicula con id: ").append(pId)
					.toString());
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	@Override
	public Integer save(Pelicula pelicula) throws DatabaseInsertException {
		try {
			Integer result = peliculaRepository.save(pelicula);
			LOG.debug(new StringBuffer(
					"Se ha guardado en base de datos la pelicula: ").append(
					pelicula.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al insertar la pelicula en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

	@Override
	public void update(Pelicula pelicula) throws DatabaseInsertException {
		try {
			peliculaRepository.update(pelicula);
			LOG.debug(new StringBuffer("Se ha actualizado la pelicula: ")
					.append(pelicula.getTitulo()).toString());
		} catch (SQLException e) {
			LOG.error("Error al actualizar el pelicula en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

}
