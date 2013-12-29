package com.hsl.library.model.bean;

// TODO: Auto-generated Javadoc
/**
 * The Enum Decada.
 */
public enum Decada {

	/** The S40. */
	S40("40s", 1940, 1950),

	/** The S50. */
	S50("50s", 1950, 1960),

	/** The S60. */
	S60("60s", 1960, 1970),

	/** The S70. */
	S70("70s", 1970, 1980),

	/** The S80. */
	S80("80s", 1980, 1990),

	/** The S90. */
	S90("90s", 1990, 2000),

	/** The S00. */
	S00("00s", 2000, 2010),

	/** The S10. */
	S10("10s", 2010, 2020);

	/** The max decada. */
	private Integer maxDecada;

	/** The min decada. */
	private Integer minDecada;

	/** The nameId. */
	private String nameId;

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Decada getValue(String value) {
		Decada result = null;
		for (Decada decada : Decada.values()) {
			if (decada.getNameId().equals(value)) {
				result = decada;
				break;
			}
		}
		return result;
	}

	/**
	 * Instantiates a new nameId.
	 * 
	 * @param nameId
	 *            the nameId
	 * @param minDecada
	 *            the min decada
	 * @param maxDecada
	 *            the max decada
	 */
	private Decada(String nameId, Integer minDecada, Integer maxDecada) {
		this.nameId = nameId;
		this.minDecada = minDecada;
		this.maxDecada = maxDecada;
	}

	/**
	 * Gets the max decada.
	 * 
	 * @return the max decada
	 */
	public Integer getMaxDecada() {
		return this.maxDecada;
	}

	/**
	 * Gets the min decada.
	 * 
	 * @return the min decada
	 */
	public Integer getMinDecada() {
		return this.minDecada;
	}

	/**
	 * Gets the nameId.
	 * 
	 * @return the nameId
	 */
	public String getNameId() {
		return this.nameId;
	}
}
