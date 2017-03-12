package com.frc.chooseoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.exception.AppleException;
import com.turtle.activity.common.ActivityType;
import com.turtle.activity.dao.service.ActivityService;

import net.sf.json.JSONObject;

@Service
public class GroupActivityService {
	
	@Autowired
	private ActivityService service = null;
	
	protected int addGroupActivity(String username, int id, String groupName) throws AppleException {
		String result = buildAddGroupResult(id, groupName);
		
		int rt = service.addActivity(username, ActivityType.ADDGROUP.name(), result);
		
		return rt;
	}
	
	protected String buildAddGroupResult(int id, String groupName) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("groupName", groupName);
		return obj.toString();
	}
}
