package com.frc.chooseoption.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.util.StringUtil;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.OptionExample;
import com.frc.chooseoption.entity.OptionExample.Criteria;
import com.frc.chooseoption.entity.OptionMapper;

@Service
public class OptionDao {
	private static Logger logger = LoggerFactory.getLogger(OptionDao.class);
	
	@Autowired
	protected SqlSessionFactory sessionFactory = null;
	
	public int addOption(int groupId, String optionName, int probability) {
		logger.debug("Add Option [groupId={},optionName={},probability={}]", 
				groupId, optionName, probability);
		SqlSession session = sessionFactory.openSession();
		
		OptionMapper mapper = session.getMapper(OptionMapper.class);
		
		Option option = new Option();
		option.setGroupid(groupId);
		option.setOptionname(optionName);
		option.setProbability(probability);
		mapper.insert(option);
		
		int id = option.getOptionid();
		logger.debug("optionId={}, optionName={}", option.getOptionid(), option.getOptionname());
		return id;
	}
	
	public int addOption(int groupId, List<String>optionNameList, List<Integer>probabilityList) {
		logger.debug("Batch Add Option [groupId={}]", groupId);
		
		if (optionNameList == null) {
			logger.warn("optionNameList is null");
			return 0;
		} else if (probabilityList == null) {
			logger.warn("probabilityList is null");
			return 0;
		} else if (optionNameList.size() != probabilityList.size()) {
			logger.warn("optionNameList.size() not equal probabilityList.size()");
			return 0;
		}
		
		SqlSession session = sessionFactory.openSession();
		OptionMapper mapper = session.getMapper(OptionMapper.class);
		
		List<Option> list = new ArrayList<>();
		for (int i = 0; i < optionNameList.size(); i++) {
			Option option = new Option();
			option.setGroupid(groupId);
			option.setOptionname(optionNameList.get(i));
			option.setProbability(probabilityList.get(i));
			list.add(option);
		}
		int rt = mapper.batchInsert(list);
		
		return rt;
	}
	
	public List<Option> queryOption(int groupId) {
		logger.debug("Query Option [id={}]", groupId);
		SqlSession session = sessionFactory.openSession();
		
		OptionMapper mapper = session.getMapper(OptionMapper.class);
		
		OptionExample example = new OptionExample();
		Criteria criteria = example.createCriteria();
		if (groupId > 0) {
			criteria.andGroupidEqualTo(groupId);
		}
		
		List<Option> list = mapper.selectByExample(example);
		
		logger.debug("query done. RowCount={}", list.size());
		
		return list;
	}
	
	public int deleteGroup(int optionId, String optionName) {
		logger.debug("Delete Option [id={},optionName like {}]", optionId, optionName);
		SqlSession session = sessionFactory.openSession();
		
		OptionMapper mapper = session.getMapper(OptionMapper.class);
		
		OptionExample example = new OptionExample();
		Criteria criteria = example.createCriteria();
		if (optionId > 0) {
			criteria.andGroupidEqualTo(optionId);
		}
		if (!StringUtil.isEmpty(optionName)) {
			criteria.andOptionnameLike("%" + optionName + "%");
		}
		
		int rt = mapper.deleteByExample(example);
		
		logger.debug("Deletion done. RowCount={}", rt);
		
		return rt;
	}
	public int udpateOption(List<Integer>optionIdList, 
			List<String>optionNameList, 
			List<Integer>probabilityList) {
		logger.debug("batch update Option");
		
		if (optionIdList == null || optionIdList.size() == 0) {
			logger.warn("optionIdList is empty");
			return 0;
		} else if (optionNameList == null || optionNameList.size() == 0) {
			logger.warn("optionNameList is empty");
			return 0;
		} else if (probabilityList == null || probabilityList.size() == 0) {
			logger.warn("probabilityList is empty");
			return 0;
		}
		if (optionIdList.size() != optionNameList.size() || optionIdList.size() != probabilityList.size()) {
			logger.warn("optionIdList,optionNameList,probabilityList size are different");
			return 0;
		}
		
		SqlSession session = sessionFactory.openSession();
		OptionMapper mapper = session.getMapper(OptionMapper.class);
		
		List<Option> list = new ArrayList<Option>();
		for (int i = 0; i < optionIdList.size(); i++) {
			Option option = new Option();
			option.setOptionid(optionIdList.get(i));
			option.setOptionname(optionNameList.get(i));
			option.setProbability(probabilityList.get(i));
			list.add(option);
		}
		
		int rt = mapper.batchUpdate(list);
		
		logger.debug("Update done. RowCount={}", rt);
		
		return rt;
	}
}
