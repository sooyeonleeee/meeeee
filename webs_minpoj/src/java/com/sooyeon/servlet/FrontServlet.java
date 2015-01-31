package com.sooyeon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sooyeon.action.ActionFactory;
import com.sooyeon.action.IAction;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/servlet/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String cmd = request.getParameter("cmd");
		IAction action = ActionFactory.getInstance().getAction(cmd);
		action.process(request, response);
	}


}
