package com.frc.chooseoption.option.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.CreateOptionRequest;
import com.frc.chooseoption.service.OptionService;

import net.sf.json.JSONObject;

@Service("CreateOptionHandler")
public class CreateOptionHandler extends AbstractHandler {
	private static Logger logger = LoggerFactory.getLogger(CreateOptionHandler.class);
			
	@Autowired
	protected OptionService optionService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		CreateOptionRequest req = (CreateOptionRequest) request;
		
		logger.debug("CreateOptionHandler_request:" + JSONObject.fromObject(req).toString());
		
		int rt = optionService.addOption(req.getGroupId(), req.getOptions(), req.getProbabilitys());
		
		putRequestData("optionCount", rt);
	}

}
