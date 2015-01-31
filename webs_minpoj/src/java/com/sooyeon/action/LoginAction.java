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

public class LoginAction implements IAction {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String path = "/main/main.jsp";
		UserService service = UserService.getService();
		User user = new User();
		User loginUser = null;
		user.setUserId(request.getParameter("userId"));
		user.setUserPwd(request.getParameter("userPwd"));

		try {
			loginUser = service.loginService(user);
			session.setAttribute("user", loginUser);
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/error/error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}
}
