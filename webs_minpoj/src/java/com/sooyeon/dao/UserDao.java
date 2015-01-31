package com.sooyeon.dao;

import org.apache.ibatis.session.SqlSession;

import com.sooyeon.entity.User;

public interface UserDao {
	public int insertUser(SqlSession session, User user);
	public User selectUser(SqlSession session, String userId);
	public int updateUser(SqlSession session, User user);
	public int deleteUser(SqlSession session, String userId);
	
}
