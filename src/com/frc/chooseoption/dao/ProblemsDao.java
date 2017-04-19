package com.frc.chooseoption.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.chooseoption.entity.ProblemsMapper;
import com.frc.chooseoption.entity.Problems;
import com.frc.chooseoption.entity.ProblemsExample;
import com.frc.chooseoption.entity.ProblemsExample.Criteria;

@Service
public class ProblemsDao {
	private static Logger logger = LoggerFactory.getLogger(ProblemsDao.class);
	
	@Autowired
	protected SqlSessionFactory sessionFactory = null;
	
	public long addProblems(String problemNo, String date, String respondent, String status, String type) {
		logger.debug("Add Problem [problemId={},problemNo={},date={},respondent={},status={},type={}]", 
				problemNo, date, respondent, status, type);
		SqlSession session = sessionFactory.openSession();
		
		ProblemsMapper mapper = session.getMapper(ProblemsMapper.class);
		
		Problems problems = new Problems();
		problems.setProblemNo(problemNo);
		problems.setDate(date);
		problems.setRespondent(respondent);
		problems.setStatus(status);
		problems.setType(type);
		mapper.insert(problems);
		
		long id = problems.getId();
		logger.debug("problemsId={},problemsNo={}", id, problems.getProblemNo());
		return id;
	}
	public List<Problems> queryCf(String sdate,String edate) {
		logger.debug("Query Problems [sdate={},edate]", sdate,edate);
		SqlSession session = sessionFactory.openSession();
		ProblemsMapper mapper = session.getMapper(ProblemsMapper.class);
		
		ProblemsExample example = new ProblemsExample();
		Criteria criteria = example.createCriteria();
		criteria.andDateBetween(sdate, edate);
		List<Problems> list = mapper.selectByExample(example);
		System.out.println(list.size());
		logger.debug("query done. RowCount={}", list.size());
		
		return list;
	}
	
	public List<Problems> queryCf(String sdate,String edate, String type,String status,String name) {
		logger.debug("Query Problems [sdate={},edate]", sdate,edate);
		SqlSession session = sessionFactory.openSession();
		ProblemsMapper mapper = session.getMapper(ProblemsMapper.class);
		
		ProblemsExample example = new ProblemsExample();
		Criteria criteria = example.createCriteria();
		if(!sdate.isEmpty()&&!edate.isEmpty()){
			criteria.andDateBetween(sdate, edate);
		}else if(edate.isEmpty()){
			criteria.andDateGreaterThanOrEqualTo(sdate);
		}else if(sdate.isEmpty()){
			criteria.andDateLessThanOrEqualTo(edate);
		}
	
		if(!type.isEmpty()){
			criteria.andTypeEqualTo(type);
		}
		if(!status.isEmpty()){
			criteria.andStatusEqualTo(status);
		}
		if(!status.isEmpty()){
			criteria.andRespondentEqualTo(name);
		}
		List<Problems> list = mapper.selectByExample(example);
		System.out.println(list.size());
		logger.debug("query done. RowCount={}", list.size());
		
		return list;
	}
	
	public int deleteProblems(long problemsId) {
		logger.debug("Delete Problems");
		SqlSession session = sessionFactory.openSession();
		
		ProblemsMapper mapper = session.getMapper(ProblemsMapper.class);
		
		
		int rt = mapper.deleteByPrimaryKey(problemsId);
		
		logger.debug("Deletion done. RowCount={}", rt);
		
		return rt;
	}
	public int udpateOption(long problemsId, String status) {
		logger.debug("update Problems status");
		
		
		SqlSession session = sessionFactory.openSession();
		ProblemsMapper mapper = session.getMapper(ProblemsMapper.class);
		
		Problems problems = new Problems();
		problems.setStatus(status);
		problems.setId(problemsId);
		
		int rt = mapper.updateByPrimaryKeySelective(problems);
		logger.debug("Update done. RowCount={}", rt);
		
		return rt;
	}
}
