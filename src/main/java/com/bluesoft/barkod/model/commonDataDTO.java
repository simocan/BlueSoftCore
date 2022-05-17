package com.bluesoft.barkod.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class commonDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811655798308402171L;
	private String sanalBarkodNo;
	private String spoolNo;
	private String rowColor;
	private String havuz;
	private String projeAdi;
	private String devreAdi;
	private String ack;
	private int personelId;
	private int depoId;
	private int projeId;
	private String tarih;
	private String priorty;
	private BigDecimal agirlik;

	

	public String getSpoolNo() {
		return spoolNo;
	}

	public void setSpoolNo(String spoolNo) {
		this.spoolNo = spoolNo;
	}

	public String getRowColor() {
		return rowColor;
	}

	public void setRowColor(String rowColor) {
		this.rowColor = rowColor;
	}

	public String getHavuz() {
		return havuz;
	}

	public void setHavuz(String havuz) {
		this.havuz = havuz;
	}

	public String getProjeAdi() {
		return projeAdi;
	}

	public void setProjeAdi(String projeAdi) {
		this.projeAdi = projeAdi;
	}

	public String getDevreAdi() {
		return devreAdi;
	}

	public void setDevreAdi(String devreAdi) {
		this.devreAdi = devreAdi;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public int getDepoId() {
		return depoId;
	}

	public void setDepoId(int depoId) {
		this.depoId = depoId;
	}

	public int getProjeId() {
		return projeId;
	}

	public void setProjeId(int projeId) {
		this.projeId = projeId;
	}

	public String getPriorty() {
		return priorty;
	}

	public void setPriorty(String priorty) {
		this.priorty = priorty;
	}

	public String getSanalBarkodNo() {
		return sanalBarkodNo;
	}

	public void setSanalBarkodNo(String sanalBarkodNo) {
		this.sanalBarkodNo = sanalBarkodNo;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public BigDecimal getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(BigDecimal agirlik) {
		this.agirlik = agirlik;
	}

}
