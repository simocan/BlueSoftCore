package com.bluesoft.barkod.model;


public class ApiResponseDTO {
	
	private String apiURL;
	private String appId;
	private String role;
	private String methodId;
	private String serverMetadata;
	private String uiMetadata;
	
	public ApiResponseDTO(String apiURL, String appId, String role, String methodId, String serverMetadata, String uiMetadata) {
		super();
		this.apiURL = apiURL;
		this.appId = appId;
		this.role = role;
		this.methodId = methodId;
		this.serverMetadata = serverMetadata;
		this.uiMetadata = uiMetadata;
	}
	
	
	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMethodId() {
		return methodId;
	}

	public void setMethodId(String methodId) {
		this.methodId = methodId;
	}

	public String getServerMetadata() {
		return serverMetadata;
	}

	public void setServerMetadata(String serverMetadata) {
		this.serverMetadata = serverMetadata;
	}

	public String getUiMetadata() {
		return uiMetadata;
	}

	public void setUiMetadata(String uiMetadata) {
		this.uiMetadata = uiMetadata;
	}

	
	
	
}
