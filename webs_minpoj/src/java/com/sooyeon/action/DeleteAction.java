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

public class DeleteAction implements IAction {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/main/main.jsp";
		HttpSession session = request.getSession();
		UserService service = UserService.getService();
		User user = (User) session.getAttribute("user");
		
		try {
			service.deleteService(user.getUserId());
			session.invalidate();
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
