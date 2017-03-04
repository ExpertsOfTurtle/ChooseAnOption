package com.frc.chooseoption.group.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.CreateGroupRequest;
import com.frc.chooseoption.service.GroupService;

import net.sf.json.JSONObject;

@Service("CreateGroupHandler")
public class CreateGroupHandler extends AbstractHandler {
	private static Logger logger  =  LoggerFactory.getLogger(CreateGroupHandler.class);
			
	@Autowired
	protected GroupService groupService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		CreateGroupRequest req = (CreateGroupRequest) request;
		
		logger.debug("CreateGroupHandler_request:" + JSONObject.fromObject(req).toString());
		
		int id = groupService.addGroup(req.getGroupName());
		
		putRequestData("groupId", id);
	}

}
