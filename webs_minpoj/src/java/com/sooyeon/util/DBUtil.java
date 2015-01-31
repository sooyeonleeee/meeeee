package com.sooyeon.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBUtil {
	
	//static변수를 정의하면 생성은 나중에 되고
	//변수만 먼저 static 영역에 올라감
	static final Logger LOG = LoggerFactory.getLogger(DBUtil.class);
	
	private static DBUtil util = new DBUtil();

	public static DBUtil getUtil() {
		return util;
	}

	SqlSessionFactory factory = null;

	private DBUtil() {
		LOG.trace("mybatis 사용 준비 완료");
	}

	public SqlSession getSession() {
		//service에서는 session을 얻어와서 제대로 처리할 경우에만 commit처리
		//autocommit을 지정해주지 않으면 잘못된 처리도 commit될 수 있음.
		return factory.openSession(false);
	}
	
	public void initFactory(String resource) {
		// classpath
		//String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
			.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("sessionfactory 생성 실패", e);
		}
		this.factory = sqlSessionFactory;
	}
}
