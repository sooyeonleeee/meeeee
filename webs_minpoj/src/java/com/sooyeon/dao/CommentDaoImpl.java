package com.sooyeon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.entity.Comment;

public class CommentDaoImpl implements CommentDao {

	static final Logger LOG = LoggerFactory.getLogger(CommentDaoImpl.class);
	
private static CommentDaoImpl impl = new CommentDaoImpl();
	
	private CommentDaoImpl() {
		LOG.trace("CommentDaoImpl 사용 준비 완료");
	}
	
	public static CommentDaoImpl getInstance() {
		return impl;
	}
	

	String namespace = "com.sooyeon.mappers.commentMapper.";
	
	@Override
	public int insertComment(SqlSession session, Comment comment) {
		// TODO Auto-generated method stub
		String stmt = namespace+"insertComment";
		int result = -1;
		result = session.insert(stmt, comment);
		return result;
	}

	@Override
	public List<Comment> getAllComment(SqlSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getComment(SqlSession session, int CommentNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
