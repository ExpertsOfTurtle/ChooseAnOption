package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class UpdateCfRequest extends AppleRequest {
	protected String problemNo;
	protected String status;
	
	public String getProblemNo() {
		return problemNo;
	}
	public void setProblemNo(String problemNo) {
		this.problemNo = problemNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
