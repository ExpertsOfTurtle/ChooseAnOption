package test.chooseoption.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.frc.chooseoption.entity.OptionGroup;
import com.frc.chooseoption.entity.OptionGroupMapper;

public class MyBatisDemo {
	@Test
	public void test() {
		String resource = "conf.xml";
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
		// ����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		// Reader reader = Resources.getResourceAsReader(resource);
		// ����sqlSession�Ĺ���
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// ������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		session.getConfiguration().addMapper(OptionGroupMapper.class);
		
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		OptionGroupMapper mapper = session.getMapper(OptionGroupMapper.class);
		
		OptionGroup group = new OptionGroup();
//		group.setGroupid(21);
		group.setGroupname("Group002");
		int id = mapper.insertSelective(group);
		System.out.println("result:" + id);
		
		session.commit();
		session.close();
	}
}
