package com.frc.chooseoption.group.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.DeleteGroupRequest;
import com.frc.chooseoption.service.GroupService;

import net.sf.json.JSONObject;

@Service("DeleteGroupHandler")
public class DeleteGroupHandler extends AbstractHandler {
	private static Logger logger  =  LoggerFactory.getLogger(DeleteGroupHandler.class);
			
	@Autowired
	protected GroupService groupService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		DeleteGroupRequest req = (DeleteGroupRequest) request;
		
		logger.debug("DeleteGroupHandler_request:" + JSONObject.fromObject(req).toString());
		
		int rt = groupService.deleteGroup(req.getGroupId(), req.getGroupName());
		
		putRequestData("deletionCount", rt);
	}

}
