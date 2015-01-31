package com.sooyeon.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.entity.User;
import com.sooyeon.service.UserService;

public class IdCheckAction implements IAction {

	static final Logger LOG = LoggerFactory.getLogger(IdCheckAction.class);
	UserService service = UserService.getService();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("userId");
		LOG.trace(id);
		User result = null;
		try {
			result = service.selectUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("idCheck", e);
			throw new ServletException(e);
		}
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		String path = "/join/idconfirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}
