package com.frc.chooseoption.beans;

import com.frc.appleframework.beans.AppleRequest;

public class UpdateGroupRequest extends AppleRequest {
	protected int groupId;
	protected String groupName;
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
