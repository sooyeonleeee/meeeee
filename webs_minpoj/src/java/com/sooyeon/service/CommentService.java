package com.sooyeon.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.dao.CommentDaoImpl;
import com.sooyeon.entity.Comment;
import com.sooyeon.exception.ServiceFailException;
import com.sooyeon.util.DBUtil;

public class CommentService {
	
	static final Logger LOG = LoggerFactory.getLogger(CommentService.class);
	
	private CommentDaoImpl impl = CommentDaoImpl.getInstance();
	
	private DBUtil util = DBUtil.getUtil();
	
	private static CommentService service = new CommentService();

	private CommentService() {
		LOG.trace("CommentService 사용 준비 완료");
	}

	public static CommentService getService() {
		return service;
	}
	
	public void insertService(Comment comment) throws ServiceFailException {
		SqlSession session = util.getSession();
		int result = impl.insertComment(session, comment);
		
		if (result>0) {
			session.commit();
			LOG.trace("comment 추가 성공 - "+comment);
		}
		
		session.close();
		LOG.trace("session 종료");
		
		if (result <= 0) {
			throw new ServiceFailException();
		}
		
	}
	

}
