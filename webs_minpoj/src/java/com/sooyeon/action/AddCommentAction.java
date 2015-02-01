package com.sooyeon.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sooyeon.entity.Comment;
import com.sooyeon.entity.User;
import com.sooyeon.exception.ServiceFailException;
import com.sooyeon.service.CommentService;

public class AddCommentAction implements IAction {

	static final Logger LOG = LoggerFactory.getLogger(AddCommentAction.class);
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String content = request.getParameter("comment");
		
		
		
		if (content!=null) {
			LOG.trace("내용 ------------------------------"+content);
			out.println(content);
			LOG.trace("내용끝");
		}
		
		HttpSession session  = request.getSession();
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		CommentService service = CommentService.getService();
		Comment comment = new Comment();
		comment.setCommentContent(content);
		comment.setUserId(userId);
	
		
		try {
			service.insertService(comment);
			session.setAttribute("comment", comment);
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
