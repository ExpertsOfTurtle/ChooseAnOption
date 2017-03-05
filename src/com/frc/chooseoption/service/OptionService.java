package com.frc.chooseoption.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.util.StringUtil;
import com.frc.chooseoption.dao.GroupDao;
import com.frc.chooseoption.dao.OptionDao;
import com.frc.chooseoption.entity.Option;
import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.entity.OptionGroupExample;
import com.frc.chooseoption.entity.OptionGroupExample.Criteria;
import com.frc.chooseoption.entity.OptionGroupMapper;
import com.frc.chooseoption.entity.OptionMapper;

@Service
public class OptionService {
	private static Logger logger = LoggerFactory.getLogger(OptionService.class);

	@Autowired
	protected GroupDao groupDao = null;

	@Autowired
	protected OptionDao optionDao = null;

	@Autowired
	protected SqlSessionFactory sessionFactory = null;

	public int addOption(int groupId, String optionName, int probability) {
		List<OptionGroup> groupList = groupDao.queryGroup(groupId, "");
		if (groupList == null) {
			logger.warn("groupId({}) not exist", groupId);
			return 0;
		} else if (groupList.size() != 1) {
			logger.warn("There're multi groupId({})", groupId);
			return 0;
		}
		int rt = optionDao.addOption(groupId, optionName, probability);
		return rt;
	}

	public int addOption(int groupId, List<String> optionNameList, List<Integer> probabilityList) {
		List<OptionGroup> groupList = groupDao.queryGroup(groupId, "");
		if (groupList == null) {
			logger.warn("groupId({}) not exist", groupId);
			return 0;
		} else if (groupList.size() != 1) {
			logger.warn("There're multi groupId({})", groupId);
			return 0;
		}
		int rt = optionDao.addOption(groupId, optionNameList, probabilityList);
		return rt;
	}

	public List<Option> queryOption(int groupId) {
		List<Option> list = optionDao.queryOption(groupId);

		return list;
	}

	public int udpateOption(List<Integer>optionIdList, 
		List<String>optionNameList, 
		List<Integer>probabilityList) {
		int rt = optionDao.udpateOption(optionIdList, optionNameList, probabilityList);
		return rt;
	}
	
	public int deleteOption(List<Integer> optionIdList) {
		int rt = optionDao.deleteOption(optionIdList);
		return rt;
	}
}
