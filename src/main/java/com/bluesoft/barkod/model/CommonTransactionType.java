package com.bluesoft.barkod.model;

import java.io.Serializable;

public class CommonTransactionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811655798308402171L;
	private String spoolNo;
	private String islemTipi;
	private Integer onImalatUser;
	private Integer imalatUser;
	private Integer kaynakUser;
	private Integer sevkUser;

	public String getSpoolNo() {
		return spoolNo;
	}

	public void setSpoolNo(String spoolNo) {
		this.spoolNo = spoolNo;
	}

	public String getIslemTipi() {
		return islemTipi;
	}

	public void setIslemTipi(String islemTipi) {
		this.islemTipi = islemTipi;
	}

	public Integer getOnImalatUser() {
		return onImalatUser;
	}

	public void setOnImalatUser(Integer onImalatUser) {
		this.onImalatUser = onImalatUser;
	}

	public Integer getImalatUser() {
		return imalatUser;
	}

	public void setImalatUser(Integer imalatUser) {
		this.imalatUser = imalatUser;
	}

	public Integer getKaynakUser() {
		return kaynakUser;
	}

	public void setKaynakUser(Integer kaynakUser) {
		this.kaynakUser = kaynakUser;
	}

	public Integer getSevkUser() {
		return sevkUser;
	}

	public void setSevkUser(Integer sevkUser) {
		this.sevkUser = sevkUser;
	}

}
