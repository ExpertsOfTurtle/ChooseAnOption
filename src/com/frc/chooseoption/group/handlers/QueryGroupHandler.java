package com.frc.chooseoption.group.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.CreateGroupRequest;
import com.frc.chooseoption.beans.QueryGroupRequest;
import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.service.GroupService;

import net.sf.json.JSONObject;

@Service("QueryGroupHandler")
public class QueryGroupHandler extends AbstractHandler {
	private static Logger logger  =  LoggerFactory.getLogger(QueryGroupHandler.class);
			
	@Autowired
	protected GroupService groupService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		QueryGroupRequest req = (QueryGroupRequest) request;
		
		logger.debug("QueryGroupHandler_request:" + JSONObject.fromObject(req).toString());
		
		List<OptionGroup> list = groupService.queryGroup(req.getGroupId(), req.getGroupName());
		
		putRequestData("groupList", list);
	}

}
