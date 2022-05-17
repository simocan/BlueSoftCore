package com.bluesoft.barkod.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PROJEDEVRELER")
public class ProjeDevre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505190897412983551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ADI")
	private String name;

	@Column(name = "KODU")
	private String code;

	@Column(name = "PROJEID")
	private int projeId;

	public int getProjeId() {
		return projeId;
	}

	public void setProjeId(int projeId) {
		this.projeId = projeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

}