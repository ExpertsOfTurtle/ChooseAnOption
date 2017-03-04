package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class CreateGroupRequest extends AppleRequest {
	protected String groupName;
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
