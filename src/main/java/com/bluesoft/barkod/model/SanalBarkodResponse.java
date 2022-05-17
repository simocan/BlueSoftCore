package com.bluesoft.barkod.model;

import java.io.Serializable;

public class SanalBarkodResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5332740493670587124L;
	/**
	 * 
	 */
	private String spoolNo;
	private String devreAdi;
	private String duzey;

	public String getSpoolNo() {
		return spoolNo;
	}

	public void setSpoolNo(String spoolNo) {
		this.spoolNo = spoolNo;
	}

	public String getDevreAdi() {
		return devreAdi;
	}

	public void setDevreAdi(String devreAdi) {
		this.devreAdi = devreAdi;
	}

	public String getDuzey() {
		return duzey;
	}

	public void setDuzey(String duzey) {
		this.duzey = duzey;
	}

}
