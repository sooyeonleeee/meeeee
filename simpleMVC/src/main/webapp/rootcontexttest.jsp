<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="simple.service.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>root context test</title>
</head>
<body>

<%
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
	DeptService service = ctx.getBean(DeptService.class);
	out.println(service.serviceMessage());
	%>

</body>
</html>