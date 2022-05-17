package com.bluesoft.barkod.model;

public class CalculateDataRequest {

	private Long projectId;
	private Long projectDevreId;
	private Long priorty;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getProjectDevreId() {
		return projectDevreId;
	}

	public void setProjectDevreId(Long projectDevreId) {
		this.projectDevreId = projectDevreId;
	}

	public Long getPriorty() {
		return priorty;
	}

	public void setPriorty(Long priorty) {
		this.priorty = priorty;
	}

}
