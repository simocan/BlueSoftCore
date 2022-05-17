package com.bluesoft.barkod.model;

import java.io.Serializable;

public class MobilActionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8959954626916816185L;
	private String actionCode;
	private int code;
	private String message;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
