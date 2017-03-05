package com.frc.chooseoption.beans;

import java.util.List;

import com.frc.appleframework.beans.AppleRequest;

public class UpdateOptionRequest extends AppleRequest {
	protected List<Integer> optionIdList;
	protected List<String>optionNameList;
	protected List<Integer>probabilityList;
	public List<Integer> getOptionIdList() {
		return optionIdList;
	}
	public void setOptionIdList(List<Integer> optionIdList) {
		this.optionIdList = optionIdList;
	}
	public List<String> getOptionNameList() {
		return optionNameList;
	}
	public void setOptionNameList(List<String> optionNameList) {
		this.optionNameList = optionNameList;
	}
	public List<Integer> getProbabilityList() {
		return probabilityList;
	}
	public void setProbabilityList(List<Integer> probabilityList) {
		this.probabilityList = probabilityList;
	}

}
