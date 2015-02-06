<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sooyeon.mvc.entity.Department" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 확인</title>
</head>
<body>
<h2>이걸로 저장할 건가요?</h2>
<c:url value="/dept/review" var="action" />
<form method="post" action="${action}" >
<label>부서명</label> : <c:out value="${editDept.departmentName }" /><br>
<label>부서ID</label> : <c:out value="${editDept.departmentId }" /><br>
<label>관리자ID</label> : <c:out value="${editDept.managerId }" /><br>
<label>부서위치</label> : <c:out value="${editDept.locationId }" /><br>
<br>

<button type="submit" name="_event_confirmed">갱신</button>
<button type="submit" name="_event_reverse">재 입력</button>
</form>
</body>
</html>