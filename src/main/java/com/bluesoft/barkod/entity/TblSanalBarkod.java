package com.bluesoft.barkod.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SANALBARKOD")
public class TblSanalBarkod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505190897412983551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SANALBARKOD")
	private Long sanalBarkod;

	@Column(name = "SPOOLNO")
	private String spoolNo;

	@Column(name = "FATURAID")
	private String faturId;

	@Column(name = "HAVUZ")
	private String havuz;
	
	@Column(name = "PERSONEL_ID")
	private Integer personelId;
	
	
	@Column(name = "TARIH")
	private Date tarih;
	
	

	public Integer getPersonelId() {
		return personelId;
	}

	public void setPersonelId(Integer personelId) {
		this.personelId = personelId;
	}

	public String getHavuz() {
		return havuz;
	}

	public void setHavuz(String havuz) {
		this.havuz = havuz;
	}

	public Long getSanalBarkod() {
		return sanalBarkod;
	}

	public void setSanalBarkod(Long sanalBarkod) {
		this.sanalBarkod = sanalBarkod;
	}

	public String getSpoolNo() {
		return spoolNo;
	}

	public void setSpoolNo(String spoolNo) {
		this.spoolNo = spoolNo;
	}

	public String getFaturId() {
		return faturId;
	}

	public void setFaturId(String faturId) {
		this.faturId = faturId;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

}