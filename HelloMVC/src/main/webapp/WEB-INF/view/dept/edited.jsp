<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>갱신완료</h1>

<label>부서명</label> : <c:out value="${editDept.departmentName }" /><br>
<label>부서ID</label> : <c:out value="${editDept.departmentId }" /><br>
<label>관리자ID</label> : <c:out value="${editDept.managerId }" /><br>
<label>부서위치</label> : <c:out value="${editDept.locationId }" /><br>
<br>

<c:url var="url" value="/dept/list" />
<a href="${url }">목록</a>
</body>
</html>