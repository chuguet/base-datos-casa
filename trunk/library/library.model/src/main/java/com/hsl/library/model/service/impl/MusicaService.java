package com.hsl.library.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hsl.library.model.bean.Musica;
import com.hsl.library.model.exception.DatabaseDeleteException;
import com.hsl.library.model.exception.DatabaseInsertException;
import com.hsl.library.model.exception.DatabaseRetrieveException;
import com.hsl.library.model.repository.IMusicaRepository;
import com.hsl.library.model.service.IMusicaService;

// TODO: Auto-generated Javadoc
/**
 * The Class MusicaService.
 */
@Service
class MusicaService implements IMusicaService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(MusicaService.class);

	/** The musica repository. */
	@Inject
	private IMusicaRepository musicaRepository;

	/* (non-Javadoc)
	 * @see com.hsl.library.model.service.IModelService#delete(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void delete(Musica musica) throws DatabaseDeleteException {
		try {
			musicaRepository.delete(musica);
			LOG.debug(new StringBuffer("Se ha borrado la musica con id: ")
					.append(musica.getId()).toString());
		} catch (SQLException e) {
			LOG.error("Error al borrar la musica de base de datos.");
			throw new DatabaseDeleteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.service.IModelService#findAll()
	 */
	@Override
	public List<Musica> findAll() throws DatabaseRetrieveException {
		try {
			List<Musica> result = musicaRepository.findAll();
			LOG.debug(new StringBuffer("Se han recuperado ")
					.append(result.size()).append(" musicas.").toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al recuperar todas las musicas de base de datos.");
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public Musica findOne(Integer pId) throws DatabaseRetrieveException {
		try {
			Musica result = musicaRepository.findOne(pId);
			LOG.debug(new StringBuffer("Se ha recuperado la musica: ").append(
					result.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error(new StringBuffer("Error al recuperar la musica con id: ")
					.append(pId).toString());
			throw new DatabaseRetrieveException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.service.IModelService#save(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public Integer save(Musica musica) throws DatabaseInsertException {
		try {
			Integer result = musicaRepository.save(musica);
			LOG.debug(new StringBuffer(
					"Se ha guardado en base de datos la musica: ").append(
					musica.getTitulo()).toString());
			return result;
		} catch (SQLException e) {
			LOG.error("Error al insertar la musica en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.service.IModelService#update(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void update(Musica musica) throws DatabaseInsertException {
		try {
			musicaRepository.update(musica);
			LOG.debug(new StringBuffer("Se ha actualizado la musica: ").append(
					musica.getTitulo()).toString());
		} catch (SQLException e) {
			LOG.error("Error al actualizar la musica en base de datos.");
			throw new DatabaseInsertException(e.getMessage(), e);
		}
	}

}
