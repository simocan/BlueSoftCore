package com.bluesoft.barkod.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AKIS_HAVUZ_PERSONEL")
public class AkisHavuzPersonel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505190897412983551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "HAVUZ")
	private String havuz;

	@Column(name = "PERSONEL_ID")
	private int personelId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHavuz() {
		return havuz;
	}

	public void setHavuz(String havuz) {
		this.havuz = havuz;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	
	

	
}