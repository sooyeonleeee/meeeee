<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "sooyeon.mvc.entity.Department" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>부서 정보</title>
<link href="<%=request.getContextPath() %>/css/detail.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>부서 정보</h2>
<label>부서명</label> : <c:out value="${dept.departmentName }" /><br>
<label>부서ID</label> : <c:out value="${dept.departmentId }" /><br>
<label>관리자ID</label> : <c:out value="${dept.managerId }" /><br>
<label>부서위치</label> : <c:out value="${dept.locationId }" /><br>
<br>

<c:url value="/dept/list" var="url"></c:url>
<a href="${url }"><button>목록 보기</button></a>
</body>
</html>