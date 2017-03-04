package com.frc.chooseoption.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.appleframework.util.StringUtil;
import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.entity.OptionGroupExample;
import com.frc.chooseoption.entity.OptionGroupExample.Criteria;
import com.frc.chooseoption.entity.OptionGroupMapper;

@Service
public class GroupDao {
	private static Logger logger = LoggerFactory.getLogger(GroupDao.class);
	
	@Autowired
	protected SqlSessionFactory sessionFactory = null;
	
	public int addGroup(String groupName) {
		logger.debug("Add OptionGroup[name={}]", groupName);
		SqlSession session = sessionFactory.openSession();
		
		OptionGroupMapper mapper = session.getMapper(OptionGroupMapper.class);
		
		OptionGroup group = new OptionGroup();
		group.setGroupname(groupName);
		mapper.insert(group);
		
		int id = group.getGroupid();
		logger.debug("groupId={}, groupName={}", group.getGroupid(), group.getGroupname());
		return id;
	}
	
	public List<OptionGroup> queryGroup(int id, String groupName) {
		logger.debug("Query OptionGroup[id={},groupName like {}]", id, groupName);
		SqlSession session = sessionFactory.openSession();
		
		OptionGroupMapper mapper = session.getMapper(OptionGroupMapper.class);
		
		OptionGroupExample example = new OptionGroupExample();
		Criteria criteria = example.createCriteria();
		if (id > 0) {
			criteria.andGroupidEqualTo(id);
		}
		if (!StringUtil.isEmpty(groupName)) {
			criteria.andGroupnameLike("%" + groupName + "%");
		}
		
		List<OptionGroup> list = mapper.selectByExample(example);
		
		logger.debug("query done. RowCount={}", list.size());
		
		return list;
	}
	
	public int deleteGroup(int id, String groupName) {
		logger.debug("Delete OptionGroup[id={},groupName like {}]", id, groupName);
		SqlSession session = sessionFactory.openSession();
		
		OptionGroupMapper mapper = session.getMapper(OptionGroupMapper.class);
		
		OptionGroupExample example = new OptionGroupExample();
		Criteria criteria = example.createCriteria();
		if (id > 0) {
			criteria.andGroupidEqualTo(id);
		}
		if (!StringUtil.isEmpty(groupName)) {
			criteria.andGroupnameLike("%" + groupName + "%");
		}
		
		int rt = mapper.deleteByExample(example);
		
		logger.debug("Deletion done. RowCount={}", rt);
		
		return rt;
	}
}
