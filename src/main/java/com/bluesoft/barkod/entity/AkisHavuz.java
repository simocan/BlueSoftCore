package com.bluesoft.barkod.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AKIS_HAVUZ")
public class AkisHavuz implements Serializable {

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

	@Column(name = "PRIORTY")
	private int priorty;

	@Column(name = "ACK")
	private String ack;

	@Column(name = "STATE")
	private String state;
	
	@Column(name = "TIP")
	private String tip;
	
	
	@Column(name = "COLOR")
	private String color;
	
	
	@Column(name = "CURRENT_HAVUZ")
	private String currentHavuz;

	public String getCurrentHavuz() {
		return currentHavuz;
	}

	public void setCurrentHavuz(String currentHavuz) {
		this.currentHavuz = currentHavuz;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
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

	public int getPriorty() {
		return priorty;
	}

	public void setPriorty(int priorty) {
		this.priorty = priorty;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}