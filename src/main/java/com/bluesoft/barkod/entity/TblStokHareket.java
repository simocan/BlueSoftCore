package com.bluesoft.barkod.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_STOKHAREKETLERI")
public class TblStokHareket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5620860398499010572L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FATURAID")
	private Long faturaId;
	
	@Column(name = "IRSALIYEID")
	private Long irsaliyeId;
	
	@Column(name = "STOKKODU")
	private String stokKodu;
	
	@Column(name = "GCKODU")
	private String gckKodu;
	
	@Column(name = "MIKTAR")
	private BigDecimal miktar;
	
	@Column(name = "BIRIMFIYAT")
	private BigDecimal birimFiyat;
	
	@Column(name = "KDV")
	private BigDecimal kdv;
	
	@Column(name = "TIPI")
	private String tipi;
	
	@Column(name = "DEPOID")
	private Long depoId;
	
	
	@Column(name = "SAVEUSER")
	private Long saveUser;
	
	@Column(name = "SAVEDATE")
	private Date saveDate;
	
	@Column(name = "EDITUSER")
	private Long editUser;
	
	@Column(name = "EDITDATE")
	private Date editDate;
 
	
	@Column(name = "ONIMALATUSER")
	private Long onImalatUser;
	
	@Column(name = "ONIMALATDATE")
	private Date onImalatDate;
	
	@Column(name = "IMALATUSER")
	private Long imalatUser;
	
	@Column(name = "IMALATDATE")
	private Date imalatDate;
	
	@Column(name = "KAYNAKUSER")
	private Long kaynakUser;
	
	@Column(name = "KAYNAKDATE")
	private Date kaynakDate;
	
	@Column(name = "SEVKUSER")
	private Long sevkUser;
	
	@Column(name = "SEVKDATE")
	private Date sevkDate;
	
	@Column(name = "SABITAGIRLIK")
	private BigDecimal sabitAqirlik;
	
	@Column(name = "AGIRLIKMIKTARI")
	private BigDecimal agirlikMiktari;
	
	@Column(name = "SPOOLNO")
	private String spoolNo;
	
	@Column(name = "INC")
	private String inc;
	
	@Column(name = "SANALBARKOD")
	private String sanalBarkod;
	
	@Column(name = "ISLEMTIPI")
	private String islemTipi;
	
	@Column(name = "STOKID")
	private Long stokId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFaturaId() {
		return faturaId;
	}

	public void setFaturaId(Long faturaId) {
		this.faturaId = faturaId;
	}

	public Long getIrsaliyeId() {
		return irsaliyeId;
	}

	public void setIrsaliyeId(Long irsaliyeId) {
		this.irsaliyeId = irsaliyeId;
	}

	public String getStokKodu() {
		return stokKodu;
	}

	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}

	public String getGckKodu() {
		return gckKodu;
	}

	public void setGckKodu(String gckKodu) {
		this.gckKodu = gckKodu;
	}

	public BigDecimal getMiktar() {
		return miktar;
	}

	public void setMiktar(BigDecimal miktar) {
		this.miktar = miktar;
	}

	public BigDecimal getBirimFiyat() {
		return birimFiyat;
	}

	public void setBirimFiyat(BigDecimal birimFiyat) {
		this.birimFiyat = birimFiyat;
	}

	public BigDecimal getKdv() {
		return kdv;
	}

	public void setKdv(BigDecimal kdv) {
		this.kdv = kdv;
	}

	public String getTipi() {
		return tipi;
	}

	public void setTipi(String tipi) {
		this.tipi = tipi;
	}

	public Long getDepoId() {
		return depoId;
	}

	public void setDepoId(Long depoId) {
		this.depoId = depoId;
	}

	public Long getSaveUser() {
		return saveUser;
	}

	public void setSaveUser(Long saveUser) {
		this.saveUser = saveUser;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Long getEditUser() {
		return editUser;
	}

	public void setEditUser(Long editUser) {
		this.editUser = editUser;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public Long getOnImalatUser() {
		return onImalatUser;
	}

	public void setOnImalatUser(Long onImalatUser) {
		this.onImalatUser = onImalatUser;
	}

	public Date getOnImalatDate() {
		return onImalatDate;
	}

	public void setOnImalatDate(Date onImalatDate) {
		this.onImalatDate = onImalatDate;
	}

	public Long getImalatUser() {
		return imalatUser;
	}

	public void setImalatUser(Long imalatUser) {
		this.imalatUser = imalatUser;
	}

	public Date getImalatDate() {
		return imalatDate;
	}

	public void setImalatDate(Date imalatDate) {
		this.imalatDate = imalatDate;
	}

	public Long getKaynakUser() {
		return kaynakUser;
	}

	public void setKaynakUser(Long kaynakUser) {
		this.kaynakUser = kaynakUser;
	}

	public Date getKaynakDate() {
		return kaynakDate;
	}

	public void setKaynakDate(Date kaynakDate) {
		this.kaynakDate = kaynakDate;
	}

	public Long getSevkUser() {
		return sevkUser;
	}

	public void setSevkUser(Long sevkUser) {
		this.sevkUser = sevkUser;
	}

	public Date getSevkDate() {
		return sevkDate;
	}

	public void setSevkDate(Date sevkDate) {
		this.sevkDate = sevkDate;
	}

	public BigDecimal getSabitAqirlik() {
		return sabitAqirlik;
	}

	public void setSabitAqirlik(BigDecimal sabitAqirlik) {
		this.sabitAqirlik = sabitAqirlik;
	}

	public BigDecimal getAgirlikMiktari() {
		return agirlikMiktari;
	}

	public void setAgirlikMiktari(BigDecimal agirlikMiktari) {
		this.agirlikMiktari = agirlikMiktari;
	}

	public String getSpoolNo() {
		return spoolNo;
	}

	public void setSpoolNo(String spoolNo) {
		this.spoolNo = spoolNo;
	}

	public String getInc() {
		return inc;
	}

	public void setInc(String inc) {
		this.inc = inc;
	}

	public String getSanalBarkod() {
		return sanalBarkod;
	}

	public void setSanalBarkod(String sanalBarkod) {
		this.sanalBarkod = sanalBarkod;
	}

	public String getIslemTipi() {
		return islemTipi;
	}

	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}

	public Long getStokId() {
		return stokId;
	}

	public void setStokId(Long stokId) {
		this.stokId = stokId;
	}

	

	
}