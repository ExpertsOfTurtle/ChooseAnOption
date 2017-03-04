package com.frc.chooseoption.beans;

import java.util.List;

import com.frc.appleframework.beans.AppleRequest;

public class CreateOptionRequest extends AppleRequest {
	protected List<String> options;
	protected List<Integer> probabilitys;
	protected int groupId;
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public List<Integer> getProbabilitys() {
		return probabilitys;
	}
	public void setProbabilitys(List<Integer> probabilitys) {
		this.probabilitys = probabilitys;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
