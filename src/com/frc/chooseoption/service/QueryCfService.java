package com.frc.chooseoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.exception.AppleException;
import com.frc.chooseoption.dao.ProblemsDao;
import com.frc.chooseoption.entity.Problems;

@Service
public class QueryCfService {


	@Autowired
	public ProblemsDao problemsDao = null;
	
	public List<Problems> querycf(String sdate,String edate, String type, String status, String name) throws AppleException{
		
		List<Problems> res=problemsDao.queryCf(sdate, edate, type,status,name);
		
		return res;
	}
	
}
