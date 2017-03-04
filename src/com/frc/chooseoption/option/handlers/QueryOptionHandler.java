package com.frc.chooseoption.option.handlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.beans.IRequest;
import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.hanlders.AbstractHandler;
import com.frc.chooseoption.beans.CreateOptionRequest;
import com.frc.chooseoption.beans.QueryOptionRequest;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.service.OptionService;

import net.sf.json.JSONObject;

@Service("QueryOptionHandler")
public class QueryOptionHandler extends AbstractHandler {
	private static Logger logger = LoggerFactory.getLogger(QueryOptionHandler.class);
			
	@Autowired
	protected OptionService optionService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		QueryOptionRequest req = (QueryOptionRequest) request;
		
		logger.debug("QueryOptionHandler_request:" + JSONObject.fromObject(req).toString());
		
		List<Option> list = optionService.queryOption(req.getGroupId());
		
		putRequestData("optionList", list);
	}

}
