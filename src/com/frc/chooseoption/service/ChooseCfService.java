package com.frc.chooseoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.chooseoption.dao.OptionDao;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.Problems;
import com.frc.chooseoption.util.DateUtil;

@Service
public class ChooseCfService {

	@Autowired
	public ProblemsDao problemsDao1 = null;

	@Autowired
	public OptionDao optionDao1 = null;

	public List<Problems> chooseCf(){
		String sdate=DateUtil.getTodayDate();
		String edate=DateUtil.getTodayDate();
		String type="A";
		
		List<Option> option_wf=optionDao1.queryOption(0);
		List<Option> option_c=optionDao1.queryOption(1);
		List<Problems> problems=problemsDao1.queryCf(sdate, edate, type,"","");

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
				problemsDao1.addProblems(type_wf, sdate, "DFS", "0", "A");
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
				problemsDao1.addProblems(type_c, sdate, "Could", "0", "A");
			}
		}
		problems=problemsDao1.queryCf(sdate, edate, type,"","");
		return problems;
	}
}
