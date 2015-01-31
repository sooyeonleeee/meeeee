package com.sooyeon.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sooyeon.entity.Reply;

public interface ReplyDao {
	public int insertReply(SqlSession session, Reply reply);
	public List<Reply> getReply(SqlSession session, int commentNo);
}
