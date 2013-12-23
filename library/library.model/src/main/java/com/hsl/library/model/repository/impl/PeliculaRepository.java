package com.hsl.library.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hsl.library.model.bean.Pelicula;
import com.hsl.library.model.repository.IPeliculaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PeliculaRepository.
 */
@Repository
class PeliculaRepository implements IPeliculaRepository {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#save(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public Integer save(Pelicula pelicula) throws SQLException {
		return (Integer) hibernateTemplate.save(pelicula);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#update(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void update(Pelicula pelicula) throws SQLException {
		hibernateTemplate.update(pelicula);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#delete(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void delete(Pelicula pelicula) throws SQLException {
		hibernateTemplate.delete(pelicula);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#findOne(java.lang.Integer)
	 */
	@Override
	public Pelicula findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Pelicula.class, pId);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Pelicula> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Pelicula.class);
	}

}
