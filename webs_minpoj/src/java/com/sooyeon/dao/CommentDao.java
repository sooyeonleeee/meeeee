package com.sooyeon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sooyeon.entity.Comment;

public interface CommentDao {
	public int insertComment(SqlSession session, Comment comment);
	public List<Comment> getAllComment(SqlSession session);
	public Comment getComment(SqlSession session, int CommentNo);
}
