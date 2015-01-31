package com.sooyeon.action;

import java.util.HashMap;

import javax.servlet.ServletException;

public class ActionFactory {
	HashMap<String, IAction> map = new HashMap<String, IAction>();
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		initFactory();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public void initFactory() {
		map.put("idCheck", new IdCheckAction());
		map.put("toJoin", new ToJoinAction());
		map.put("logout", new LogoutAction());
		map.put("login", new LoginAction());
		map.put("joinProcess", new JoinProcessAction());
		map.put("update", new UpdateAction());
		map.put("delete", new DeleteAction());
		map.put("addComment", new AddCommentAction());
	}
	
	public IAction getAction(String cmd) throws ServletException {
		IAction action = map.get(cmd);
		if (action == null) {
			throw new ServletException(cmd+"로 등록된 Action 없음");
		}
		return action;
	}
}
