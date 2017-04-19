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
import com.frc.chooseoption.group.handlers.CreateGroupHandler;
import com.frc.chooseoption.service.ChooseService;
import com.frc.chooseoption.service.QueryCfService;

import net.sf.json.JSONObject;

@Service("QueryCfHandler")
public class QueryCfHandler extends AbstractHandler{

	private static Logger logger  =  LoggerFactory.getLogger(CreateGroupHandler.class);
	
	@Autowired
	protected QueryCfService queryCfService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		QueryCfRequest req = (QueryCfRequest) request;
		
		logger.debug("QueryCfHandler_request:" + JSONObject.fromObject(req).toString());
		
		List res = queryCfService.querycf(req.getSdate(), req.getEdate(), req.getType(), req.getStatus(), req.getName());
		
		putRequestData("res", res);
	}
}
