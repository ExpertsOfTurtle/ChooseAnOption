package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class ChooseOptionRequest extends AppleRequest {
	protected String date;
	protected Integer groupid;
	
	public Integer getGroupid() {
		return groupid;
	}
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	
}
