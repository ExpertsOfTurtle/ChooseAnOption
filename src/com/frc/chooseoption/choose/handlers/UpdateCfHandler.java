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
import com.frc.chooseoption.beans.QueryCfRequest;
import com.frc.chooseoption.beans.UpdateCfRequest;
import com.frc.chooseoption.group.handlers.CreateGroupHandler;
import com.frc.chooseoption.service.ChooseService;
import com.frc.chooseoption.service.CfService;

import net.sf.json.JSONObject;

@Service("UpdateCfHandler")
public class UpdateCfHandler extends AbstractHandler{

	private static Logger logger  =  LoggerFactory.getLogger(UpdateCfHandler.class);
	
	@Autowired
	protected CfService updateCfService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		UpdateCfRequest req = (UpdateCfRequest) request;
		int res =0;
		if(req.getRequestType().equals("updStatus")){
			logger.debug("QueryCfHandler_request:" + JSONObject.fromObject(req).toString());
			
			res = updateCfService.updateCfStatus(req.getProblemNo(),req.getStatus());
			
			
		}else if(req.getRequestType().equals("addPunishProNo")){
			res=(int)updateCfService.insertPunishProblem(req.getRespondent(), req.getType());
		}
		
		putRequestData("res", res);
	}
}
