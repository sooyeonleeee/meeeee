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

public class UpdateAction implements IAction {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String path = "/main/main.jsp";
		UserService service = UserService.getService();
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");

		User user = new User(userId, userName, userPwd, userEmail, userPhone);
		
		try {
			service.updateService(user);
			session.setAttribute("user", user);
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
	}

}
