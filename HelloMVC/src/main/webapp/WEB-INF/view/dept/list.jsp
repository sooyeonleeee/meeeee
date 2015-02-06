<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="sooyeon.mvc.entity.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/detail.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h2>부서 목록</h2>
	<table border="1">
		<tr>
			<th>부서 ID</th>
			<th>부서명</th>
			<th>관리자 ID</th>
			<th>위치</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${depts }" var="dept">
			<tr>
				<td><c:out value="${dept.departmentId }" /></td>
				<td><c:out value="${dept.departmentName }" /></td>
				<td><c:out value="${dept.managerId }" /></td>
				<td><c:out value="${dept.locationId }" /></td>
				<td><c:url value="/dept?departmentId=${dept.departmentId }" var="url" />
				<a href="${url }"><button>상세</button></a>
				<c:url value="/dept/edit?departmentId=${dept.departmentId }" var="url" />
				<a href="${url }"><button>편집</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>