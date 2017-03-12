package com.frc.chooseoption.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.exception.AppleException;
import com.frc.appleframework.util.StringUtil;
import com.frc.chooseoption.dao.GroupDao;
import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.entity.OptionGroupExample;
import com.frc.chooseoption.entity.OptionGroupExample.Criteria;
import com.frc.chooseoption.entity.OptionGroupMapper;

@Service
public class GroupService {
	private static Logger logger = LoggerFactory.getLogger(GroupService.class);
	
	@Autowired
	protected GroupDao groupDao = null;
	
	@Autowired
	protected GroupActivityService groupActivityService = null;
	
	
	public int addGroup(String groupName) throws AppleException {
		int rt = groupDao.addGroup(groupName);
		groupActivityService.addGroupActivity("", rt, groupName);
		return rt;
	}
	
	public List<OptionGroup> queryGroup(int id, String groupName) {
		return groupDao.queryGroup(id, groupName);
	}
	
	public int deleteGroup(int id, String groupName) {
		return groupDao.deleteGroup(id, groupName);
	}
	
	public int updateGroup(int id, String groupName) {
		return groupDao.updateGroupName(id, groupName);
	}
}
