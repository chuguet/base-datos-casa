package com.hsl.library.controller.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hsl.library.model.bean.Decada;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractUtilController.
 */
public abstract class AbstractUtilController {

	/** The date formatter. */
	private SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy");

	/**
	 * Esta en decada.
	 * 
	 * @param fecha
	 *            the fecha
	 * @param pDecada
	 *            the decada
	 * @return the boolean
	 */
	protected Boolean estaEnDecada(Date fecha, String pDecada) {
		Boolean result = Boolean.FALSE;
		Integer anno = Integer.valueOf(DATE_FORMATTER.format(fecha));
		Decada decada = Decada.getValue(pDecada);
		if(decada!=null){
			result = decada.getMinDecada() <= anno && anno < decada.getMaxDecada();
		} else{
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Gets the decadas.
	 * 
	 * @return the decadas
	 */
	protected List<String> getDecadas() {
		List<String> result = new ArrayList<String>();

		for (Decada decada : Decada.values()) {
			result.add(decada.getNameId());
		}
		return result;
	}
}
