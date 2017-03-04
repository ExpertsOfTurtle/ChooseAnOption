package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class QueryOptionRequest extends AppleRequest {
	protected int groupId;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
}
