package com.hsl.library.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hsl.library.model.bean.Libro;
import com.hsl.library.model.repository.ILibroRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LibroRepository.
 */
@Repository
class LibroRepository implements ILibroRepository {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#save(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public Integer save(Libro libro) throws SQLException {
		return (Integer) hibernateTemplate.save(libro);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#update(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void update(Libro libro) throws SQLException {
		hibernateTemplate.update(libro);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#delete(com.hsl.library.model.bean.IModelTable)
	 */
	@Override
	public void delete(Libro libro) throws SQLException {
		hibernateTemplate.delete(libro);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#findOne(java.lang.Integer)
	 */
	@Override
	public Libro findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Libro.class, pId);
	}

	/* (non-Javadoc)
	 * @see com.hsl.library.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Libro> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Libro.class);
	}

}
