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
import com.frc.chooseoption.beans.DeleteOptionRequest;
import com.frc.chooseoption.beans.QueryOptionRequest;
import com.frc.chooseoption.beans.UpdateOptionRequest;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.service.OptionService;

import net.sf.json.JSONObject;

@Service("DeleteOptionHandler")
public class DeleteOptionHandler extends AbstractHandler {
	private static Logger logger = LoggerFactory.getLogger(DeleteOptionHandler.class);
			
	@Autowired
	protected OptionService optionService = null;
	
	@Override
	public void process(IRequest request) throws AppleException {
		DeleteOptionRequest req = (DeleteOptionRequest) request;
		
		logger.debug("DeleteOptionHandler_request:" + JSONObject.fromObject(req).toString());
		
		int rt = optionService.deleteOption(req.getOptionIdList());
		
		putRequestData("deleteResult", rt);
	}

}
