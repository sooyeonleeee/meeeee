package com.sooyeon.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.dao.UserDaoImpl;
import com.sooyeon.entity.User;
import com.sooyeon.exception.ServiceFailException;
import com.sooyeon.util.DBUtil;

public class UserService {

	static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	private UserDaoImpl impl = UserDaoImpl.getInstance();

	private DBUtil util = DBUtil.getUtil();

	

	private static UserService service = new UserService();

	private UserService() {
		LOG.trace("UserService 사용 준비 완료");
	}

	public static UserService getService() {
		return service;
	}

	public void insertService(User user) throws ServiceFailException {
		SqlSession session = util.getSession();

		int result = impl.insertUser(session, user);

		if (result > 0) {
			session.commit();
			LOG.trace("user 추가 성공 - " + user);
		}

		session.close();
		LOG.trace("session 종료");

		if (result <= 0) {
			throw new ServiceFailException();
		}

	}

	public User loginService(User user) throws ServiceFailException {
		SqlSession session = util.getSession();

		User selectedUser = impl.selectUser(session, user.getUserId());

		if (selectedUser != null) {
			if (selectedUser.getUserPwd().equals(user.getUserPwd())) {
				LOG.trace("회원 조회 성공 - " + user.getUserId());
			} else {
				LOG.trace(user.getUserId() + "의 비밀번호 틀림");
				throw new ServiceFailException();
			}
		}

		session.close();
		LOG.trace("session 종료");

		if (selectedUser == null) {
			throw new ServiceFailException();
		}

		return selectedUser;
	}

	public void updateService(User user) throws ServiceFailException {
		SqlSession session = util.getSession();

		int result = impl.updateUser(session, user);

		if (result > 0) {
			session.commit();
			LOG.trace("업데이트 성공 - " + user.getUserId());
		} else {
			session.rollback();
			LOG.trace("업데이트 실패");
			throw new ServiceFailException();
		}

		session.close();
		LOG.trace("session 종료");

	}
	
	public User selectUser(String userId) {
		SqlSession session = util.getSession();
		
		User user = impl.selectUser(session, userId);
		if (user == null) {
			return null;
		}
		else {
			return user;
		}
	}
	
	public void deleteService(String userId) throws ServiceFailException {
		SqlSession session = util.getSession();
		int result = impl.deleteUser(session, userId);
		
		if (result > 0) {
			session.commit();
			LOG.trace("탈퇴 성공 - " + userId);
		} else {
			session.rollback();
			LOG.trace("탈퇴 실패");
			throw new ServiceFailException();
		}

		session.close();
		LOG.trace("session 종료");
		
	}

}
