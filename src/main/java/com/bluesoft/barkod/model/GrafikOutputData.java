package com.bluesoft.barkod.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GrafikOutputData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811655798308402171L;
	private BigDecimal islemSayilari;
	private String havuz;
	private BigDecimal percent;

	public BigDecimal getIslemSayilari() {
		return islemSayilari;
	}

	public void setIslemSayilari(BigDecimal islemSayilari) {
		this.islemSayilari = islemSayilari;
	}

	public String getHavuz() {
		return havuz;
	}

	public void setHavuz(String havuz) {
		this.havuz = havuz;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}


}
