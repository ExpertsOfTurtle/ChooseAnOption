package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class UpdateCfRequest extends AppleRequest {
	protected String problemNo;
	protected String status;
	protected String respondent;
	protected String type;
	protected int num;
	protected String deadline;
	
	public int getNum() {
		return num;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getProblemNo() {
		return problemNo;
	}
	public void setProblemNo(String problemNo) {
		this.problemNo = problemNo;
	}
	public String getStatus() {
		return status;
	}
	public String getRespondent() {
		return respondent;
	}
	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
