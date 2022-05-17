package com.bluesoft.barkod.model;


public class AppResponseDTO {

	private String appId;
	private Long expiryTime;
	private String callbackURL;

	public AppResponseDTO(String appId, Long expiryTime, String callbackURL) {
		super();
		this.appId = appId;
		this.expiryTime = expiryTime;
		this.callbackURL = callbackURL;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Long expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getCallbackURL() {
		return callbackURL;
	}

	public void setCallbackURL(String callbackURL) {
		this.callbackURL = callbackURL;
	}

}
