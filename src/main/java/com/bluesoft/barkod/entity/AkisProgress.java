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
@Table(name = "AKIS_PROGRESS")
public class AkisProgress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8505190897412983551L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "HAVUZ")
	private String name;

	@Column(name = "ACTION_USER_ID")
	private int actionUserId;

	@Column(name = "ACTION_DATE")
	private Date actionDate;

	@Column(name = "SANAL_BARKOD_NO")
	private String sanalBarkodNo;
	
	@Column(name = "CURRENT_HAVUZ")
	private String currentHavuz;
	
	@Column(name = "ACTION_TIME")
	private Date actionTime;
	
	@Column(name = "HAVUZ_ACK")
	private String havuzAck;
	

	
	public String getCurrentHavuz() {
		return currentHavuz;
	}

	public void setCurrentHavuz(String currentHavuz) {
		this.currentHavuz = currentHavuz;
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

	public int getActionUserId() {
		return actionUserId;
	}

	public void setActionUserId(int actionUserId) {
		this.actionUserId = actionUserId;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}


	public String getSanalBarkodNo() {
		return sanalBarkodNo;
	}

	public void setSanalBarkodNo(String sanalBarkodNo) {
		this.sanalBarkodNo = sanalBarkodNo;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public String getHavuzAck() {
		return havuzAck;
	}

	public void setHavuzAck(String havuzAck) {
		this.havuzAck = havuzAck;
	}

}