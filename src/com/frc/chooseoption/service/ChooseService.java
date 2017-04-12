package com.frc.chooseoption.service;

import com.frc.chooseoption.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.chooseoption.dao.GroupDao;
import com.frc.chooseoption.dao.OptionDao;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.Problems;

@Service
public class ChooseService {

	@Autowired
	protected ProblemsDao problemsDao = null;
	
	@Autowired
	protected GroupDao groupDao = null;

	@Autowired
	protected OptionDao optionDao = null;

	public List chooseoption(String date,Integer groupid){
		List res=new ArrayList();
		if(groupid.intValue()==0||groupid.intValue()==1){
			res=new ChooseCfService().chooseCf();
		}else{
			List<Option> optn=optionDao.queryOption(groupid);
			int sum=0; 
			int[] tmp=new int[optn.size()];
			for(int i=0;i<optn.size();i++){
				sum += optn.get(i).getProbability();
				tmp[i]=sum;
				int rdmno=(int)(Math.random()*sum);
				for(int j=0;j<optn.size();j++){
					if(rdmno<tmp[j]){
						res.add(optn.get(j).getOptionname());
					}
				}
			}
		}
		return res;
	}
	
}
