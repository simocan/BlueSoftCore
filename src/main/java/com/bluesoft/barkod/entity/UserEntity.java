package com.bluesoft.barkod.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_KULLANICILAR")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505190897412983551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "KULLANICI")
	private String username;

	@Column(name = "SIFRE")
	private String password;

	@Column(name = "ISIM")
	private String name;

	@Column(name = "SOYISIM")
	private String surName;

	@Column(name = "AKTIF")
	private String aktif;

	@Column(name = "KODU")
	private String code;

	@Column(name = "DEPOID")
	private Long depoId;
	
	private String depoAdi;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		Set<String> roles = new HashSet<String>();
		roles.add(RoleName.MOBIL_USER.name());
		roles.add(RoleName.WEB_USER.name());
		return roles;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getAktif() {
		return aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getDepoId() {
		return depoId;
	}

	public void setDepoId(Long depoId) {
		this.depoId = depoId;
	}

	public String getDepoAdi() {
		return depoAdi;
	}

	public void setDepoAdi(String depoAdi) {
		this.depoAdi = depoAdi;
	}

}