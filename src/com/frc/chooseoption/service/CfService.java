package com.frc.chooseoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.exception.AppleException;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Problems;
import com.frc.chooseoption.util.DateUtil;

@Service
public class CfService {


	@Autowired
	public ProblemsDao problemsDao = null;
	
	public List<Problems> querycf(String sdate,String edate, String type, String status, String name) throws AppleException{
		
		List<Problems> res=problemsDao.queryCf(sdate, edate, type,status,name);
		
		return res;
	}
	
	public int updateCfStatus(String problemsNo,String status) {
		return problemsDao.udpateProblems(problemsNo, status);
	}
	
	public long insertPunishProblem(String respondent,String type){
		String date=DateUtil.getTodayDate();
		return problemsDao.addProblems("Punishment", date, respondent, "0", type);
	}
}
