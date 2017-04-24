package com.frc.chooseoption.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.exception.AppleException;
import com.frc.chooseoption.dao.GroupDao;
import com.frc.chooseoption.dao.OptionDao;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.Problems;
import com.frc.chooseoption.util.DateUtil;
import com.turtle.activity.dao.ActivityDao;
import com.turtle.activity.entity.Activity;
import com.turtle.activity.service.ChooseActivityService;

import net.sf.json.JSONObject;

@Service
public class ChooseService {


	@Autowired
	protected GroupDao groupDao = null;

	@Autowired
	protected OptionDao optionDao = null;

	@Autowired
	protected ChooseCfService chooseCfService = null;
	@Autowired
	protected ChooseActivityService chooseactivity=null;
	
	public List chooseoption(String date,Integer groupid) throws AppleException{
		List res=new ArrayList();
		
		if(groupid.intValue()==0||groupid.intValue()==1){
			res=chooseCfService.chooseCf();
		}else{
			List<Activity> qryact=chooseactivity.queryActivity("CD", date,date,groupid.intValue());
			JSONObject param=new JSONObject();
			if(qryact.isEmpty()){
				List<Option> optn=optionDao.queryOption(groupid);
				if(!optn.isEmpty()){
					int sum=0; 
					int[] tmp=new int[optn.size()];
					for(int i=0;i<optn.size();i++){
						sum += optn.get(i).getProbability();
						tmp[i]=sum;
						
					}
					int rdmno=(int)(Math.random()*sum);
					for(int j=0;j<optn.size();j++){
						if(rdmno<tmp[j]){
							param.put("result", optn.get(j).getOptionname());
							param.put("id", groupid.intValue());
							break;
						}
					}
					chooseactivity.addActivity("CD", param);
					res=chooseactivity.queryActivity("CD", date,date,groupid.intValue());
				}else{
					Activity act=new Activity();
					act.setDescription("分组没有选项可以抽取！");
					res.add(act);
				}
			}
		}
		return res;
	}
	
}
