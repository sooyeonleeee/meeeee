<%@page import="com.sooyeon.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>수연이네 집에 오신 것을 환영합니다.</h1></center>
<%
	User newUser = (User) session.getAttribute("user");
	if (newUser != null) {
%>
	<%=newUser.getUserId() %>님 반갑습니다.
	<form method="post" action="<%=request.getContextPath() %>/servlet/FrontServlet?cmd=logout">
	<input type="submit" value="로그아웃" id="logout" name="logout"/>
	</form>
	<form method="post" action="<%=request.getContextPath() %>/servlet/FrontServlet?cmd=toJoin">
	<input type="submit" value="개인정보" id="update" name="update"/>
	</form>
	<form method="post" action="<%=request.getContextPath() %>/servlet/FrontServlet?cmd=delete">
	<input type="submit" value="탈퇴" id="delete" name="delete" />
	</form>
	<form method="post" action="<%=request.getContextPath() %>/board/boardlist.jsp">
	<input type="submit" value="게시판" id="boardlist" name="boardlist"/>
	</form>
<%
	} else  {
%>

<div align="right">
<form method="post" action="<%=request.getContextPath() %>/servlet/FrontServlet?cmd=login">
ID <input type="text" id="userId" name="userId"/>
PASS <input type="password" id="userPwd" name="userPwd"/>
<input type="submit" id="login" name= "login" value="login"/>
</form>
<form method="post" action="<%=request.getContextPath() %>/servlet/FrontServlet?cmd=toJoin" >
<input type="submit" id="sign" name="sign" value="가입"/>
</form>
</div>

<%
	}
%>
</body>
</html>