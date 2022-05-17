package com.bluesoft.barkod.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AkisHavuz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811655798308402171L;
	private String currentHavuz;
	private String ack;
	private int priorty;

	public String getCurrentHavuz() {
		return currentHavuz;
	}

	public void setCurrentHavuz(String currentHavuz) {
		this.currentHavuz = currentHavuz;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}

	public int getPriorty() {
		return priorty;
	}

	public void setPriorty(int priorty) {
		this.priorty = priorty;
	}

}
