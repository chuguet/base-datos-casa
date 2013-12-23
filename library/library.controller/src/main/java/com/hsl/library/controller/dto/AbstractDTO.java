package com.hsl.library.controller.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDTO.
 * 
 */
public abstract class AbstractDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5218320134534048788L;

	/** The id. */
	private Integer id;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
