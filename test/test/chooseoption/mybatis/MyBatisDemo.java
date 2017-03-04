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
		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		// Reader reader = Resources.getResourceAsReader(resource);
		// 构建sqlSession的工厂
		// SqlSessionFactory sessionFactory = new
		// SqlSessionFactoryBuilder().build(reader);
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		session.getConfiguration().addMapper(OptionGroupMapper.class);
		
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
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
