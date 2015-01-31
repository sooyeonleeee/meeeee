package com.sooyeon.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sooyeon.entity.User;
import com.sooyeon.exception.ServiceFailException;
import com.sooyeon.service.UserService;

public class JoinProcessAction implements IAction {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// joinform에서 입력된 값 받아옴
		
				UserService service = UserService.getService();
				
				String userId = request.getParameter("userId");
				String userName = request.getParameter("userName");
				String userPwd = request.getParameter("userPwd");
				String userEmail = request.getParameter("userEmail");
				String userPhone = request.getParameter("userPhone");
				
				// 받아온 값으로 새로운 user 생성
				User newUser = new User(userId, userName, userPwd, userEmail, userPhone);
				
				HttpSession session = request.getSession();

				
				try {
					service.insertService(newUser);
					session.setAttribute("user", newUser);
				} catch (ServiceFailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("failMessage", "회원 가입 실패");
				}

				String path = "/join/joinresult.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
				
	}

}
