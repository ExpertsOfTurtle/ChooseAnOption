package com.frc.chooseoption.choose.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.ChooseOptionRequest;
import com.frc.chooseoption.group.handlers.CreateGroupHandler;
import com.frc.chooseoption.service.ChooseService;

import net.sf.json.JSONObject;

@Service("ChooseOptionHandler")
public class ChooseOptionHandler extends AbstractHandler{

	private static Logger logger  =  LoggerFactory.getLogger(CreateGroupHandler.class);
	
	@Autowired
	protected ChooseService chooseService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		ChooseOptionRequest req = (ChooseOptionRequest) request;
		
		logger.debug("ChooseOptionHandler_request:" + JSONObject.fromObject(req).toString());
		
		List res = chooseService.chooseoption(req.getdate(), req.getGroupid());
		
		if(req.getGroupid()==0||req.getGroupid()==1){
			putRequestData("responseVM", "vm/choose/group/chooseOptionCf.vm");
		}
		
		putRequestData("res", res);
	}
}
