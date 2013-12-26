package com.hsl.library.controller.dto;

import java.nio.charset.Charset;

public abstract class AbstractBusquedaDTO {

	/** The Constant ISO_8859_1. */
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

	/** The Constant UTF_8. */
	public static final Charset UTF_8 = Charset.forName("UTF-8");

	/**
	 * Encoding.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	protected String encoding(String value) {
		return new String(value.getBytes(ISO_8859_1), UTF_8);
	}
}
