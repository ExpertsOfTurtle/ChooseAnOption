package com.frc.chooseoption.beans;

import java.util.List;

import com.frc.appleframework.beans.AppleRequest;

public class DeleteOptionRequest extends AppleRequest {
	protected List<Integer> optionIdList;

	public List<Integer> getOptionIdList() {
		return optionIdList;
	}

	public void setOptionIdList(List<Integer> optionIdList) {
		this.optionIdList = optionIdList;
	}
	
}
