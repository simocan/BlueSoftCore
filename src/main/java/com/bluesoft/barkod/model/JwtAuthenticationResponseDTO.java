package com.bluesoft.barkod.model;

import java.util.List;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.UserEntity;

public class JwtAuthenticationResponseDTO {

	private String accessToken;
	private String tokenType = "Bearer";
	private UserEntity userDetails;
	private List<Proje> projectList;

	public JwtAuthenticationResponseDTO(String accessToken, UserEntity userDetails, List<Proje> projectList) {
		this.accessToken = accessToken;
		this.userDetails = userDetails;
		this.projectList = projectList;
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

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

	public List<Proje> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Proje> projectList) {
		this.projectList = projectList;
	}

}
