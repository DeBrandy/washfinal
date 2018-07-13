package bean.daoclass;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FKSF {
	private static SqlSessionFactory sqlSessionFactory = null;
	static
	{
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
	}
	public static SqlSession getSqlSession()
	{
	return sqlSessionFactory.openSession();
	}
	public static SqlSessionFactory getSqlSessionFactory ()
	{
	return sqlSessionFactory;
	}

}
