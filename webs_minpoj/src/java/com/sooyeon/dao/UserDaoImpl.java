package com.sooyeon.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.entity.User;

public class UserDaoImpl implements UserDao {

	static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
	
	//singleton
	private static UserDaoImpl impl = new UserDaoImpl();
	
	private UserDaoImpl() {
		LOG.trace("UserDaoImpl 사용 준비 완료");
	}
	
	public static UserDaoImpl getInstance() {
		return impl;
	}

	
	String namespace = "com.sooyeon.mappers.userMapper.";
	
	@Override
	public int insertUser(SqlSession session, User user) {
		// TODO Auto-generated method stub
		
		String stmt = namespace + "insertUser";
		int result = -1;
		result = session.insert(stmt, user);
		return result;
	}

	@Override
	public User selectUser(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		String stmt = namespace + "selectUser";
		User user = session.selectOne(stmt, userId);
		return user;
	}

	@Override
	public int updateUser(SqlSession session, User user) {
		// TODO Auto-generated method stub
		String stmt = namespace + "updateUser";
		int result = -1;
		result = session.update(stmt, user);
		return result;
	}

	@Override
	public int deleteUser(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		String stmt = namespace+"deleteUser";
		int result = -1;
		result = session.delete(stmt, userId);
		return result;
	}
	


}
