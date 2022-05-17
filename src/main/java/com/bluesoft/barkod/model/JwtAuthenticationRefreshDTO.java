package com.bluesoft.barkod.model;

public class JwtAuthenticationRefreshDTO {

	private String accessToken;
	private String tokenType = "Bearer";

	public JwtAuthenticationRefreshDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


}
