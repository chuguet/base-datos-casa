package com.hsl.library.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hsl.library.model.bean.Musica;
import com.hsl.library.model.repository.IMusicaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class MusicaRepository.
 */
@Repository
class MusicaRepository implements IMusicaRepository {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.repository.IRepositoryDAO#save(com.hsl.library.
	 * model.bean.IModelTable)
	 */
	@Override
	public Integer save(Musica musica) throws SQLException {
		return (Integer) hibernateTemplate.save(musica);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.repository.IRepositoryDAO#update(com.hsl.library
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Musica musica) throws SQLException {
		hibernateTemplate.update(musica);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.repository.IRepositoryDAO#delete(com.hsl.library
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Musica musica) throws SQLException {
		hibernateTemplate.delete(musica);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsl.library.model.repository.IRepositoryDAO#findOne(java.lang.Integer
	 * )
	 */
	@Override
	public Musica findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Musica.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsl.library.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Musica> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Musica.class);
	}

}
