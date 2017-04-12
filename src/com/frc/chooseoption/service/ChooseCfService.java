package com.frc.chooseoption.service;

import com.frc.chooseoption.util.DateUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.chooseoption.dao.GroupDao;
import com.frc.chooseoption.dao.OptionDao;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.Problems;

@Service
public class ChooseCfService {

	@Autowired
	protected ProblemsDao problemsDao = null;
	
	@Autowired
	protected GroupDao groupDao = null;

	@Autowired
	protected OptionDao optionDao = null;

	public List<Problems> chooseCf(){
		String sdate=DateUtil.getTodayDate();
		String edate=DateUtil.getTodayDate();
		String type="A";
		
		List<Problems> problems=problemsDao.queryCf(sdate, edate, type);
		List<Option> option_wf=optionDao.queryOption(0);
		List<Option> option_c=optionDao.queryOption(1);
		
		if(problems.isEmpty()){
			int x = 300;
			int y = 749;
			int d = (y-x+1);
			int proId=0;
			int probability=0;
			int sumwf=0;
			int sumc=0;
			String type_wf="";
			String type_c="";
			
			int [] tmpwf=new int[option_wf.size()];
			int [] tmpc=new int[option_c.size()];
			for(int i=0;i<option_wf.size();i++){
				sumwf += option_wf.get(i).getProbability();
				tmpwf[i]=sumwf;
			}
			for(int i=0;i<option_c.size();i++){
				sumc += option_c.get(i).getProbability();
				tmpc[i] = sumc;
			}
			for(int j=0;j<5;j++ ){
				proId=(int) Math.round(Math.random()*d)+x;
				probability=(int) Math.round(Math.random()*sumwf);
				for(int k=0;k<option_wf.size();k++){
					if(probability<=tmpwf[k]){
						type_wf=option_wf.get(k).getOptionname();
						break;
					}
				}
				type_wf = String.format("http://codeforces.com/problemset/problem/%d/%s", proId,type_wf);
				problemsDao.addProblems(type_wf, sdate, "DFS", "0", "A");
			}
			for(int j=0;j<5;j++ ){
				proId=(int) Math.round(Math.random()*d)+x;
				probability=(int) Math.round(Math.random()*sumc);
				for(int k=0;k<option_c.size();k++){
					if(probability<=tmpc[k]){
						type_c=option_c.get(k).getOptionname();
						break;
					}
				}
				type_c = String.format("http://codeforces.com/problemset/problem/%d/%s", proId,type_c);
				problemsDao.addProblems(type_c, sdate, "Could", "0", "A");
			}
		}
		problems=problemsDao.queryCf(sdate, edate, type);
		return problems;
	}
}
