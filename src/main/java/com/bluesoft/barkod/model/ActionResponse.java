package com.bluesoft.barkod.model;

import java.util.ArrayList;
import java.util.List;

public class ActionResponse {

	private List<String> actionList;
	private String message;
	private int code;

	public ActionResponse() {
		actionList = new ArrayList<String>();
		code = 0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getActionList() {
		return actionList;
	}

	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
