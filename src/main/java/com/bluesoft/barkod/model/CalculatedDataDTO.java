package com.bluesoft.barkod.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculatedDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811655798308402171L;
	private String priorty;
	private BigDecimal percent;

	public String getPriorty() {
		return priorty;
	}

	public void setPriorty(String priorty) {
		this.priorty = priorty;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

}
