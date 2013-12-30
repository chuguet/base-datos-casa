package com.hsl.library.controller.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.hsl.library.model.bean.Calificacion;
import com.hsl.library.model.bean.Decada;
import com.hsl.library.model.bean.Formato;
import com.hsl.library.model.bean.Genero;

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
		if (decada != null) {
			result = decada.getMinDecada() <= anno
					&& anno < decada.getMaxDecada();
		} else {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Gets the calificaciones.
	 * 
	 * @return the calificaciones
	 */
	protected List<String> getCalificaciones() {
		List<String> result = new ArrayList<String>();
		for (Calificacion calificacion : Calificacion.values()) {
			result.add(calificacion.getNameId());
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

	/**
	 * Gets the formatos.
	 * 
	 * @return the formatos
	 */
	protected List<String> getFormatos() {
		List<String> result = new ArrayList<String>();
		for (Formato formato : Formato.values()) {
			result.add(formato.getNameId());
		}
		return result;
	}

	/**
	 * Gets the generos.
	 * 
	 * @return the generos
	 */
	protected List<String> getGeneros() {
		List<String> result = new ArrayList<String>();
		for (Genero genero : Genero.values()) {
			result.add(genero.getNameId());
		}
		return result;
	}

	/**
	 * Gets the lenguajes.
	 * 
	 * @return the lenguajes
	 */
	protected List<String> getLenguajes() {
		List<String> result = new ArrayList<String>();
		String[] languages = Locale.getISOLanguages();

		for (String language : languages) {
			Locale locale = new Locale(language);
			result.add(new StringBuffer(locale.getDisplayLanguage()
					.substring(0, 1).toUpperCase()).append(
					locale.getDisplayLanguage().substring(1)).toString());
		}
		Collections.sort(result);
		return result;
	}

	/**
	 * Gets the paises.
	 * 
	 * @return the paises
	 */
	protected List<String> getPaises() {
		List<String> result = new ArrayList<String>();
		String[] countries = Locale.getISOCountries();

		for (String country : countries) {
			Locale locale = new Locale("", country);
			result.add(locale.getDisplayName());
		}
		Collections.sort(result);
		return result;
	}
}
