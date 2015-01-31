<%@page import="com.sooyeon.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#useId").click(function() {
		opener.$("#userIdInput").val("${id}");
		self.close();
	});
});

$(document).ready(function() {
	$("#submit").click(function(){
		if($("#newId").val() == ""){
			alert("아이디를 입력하세요.");
			$("#newId").focus();
		} else {
			<c:url value="/servlet/FrontServlet" var="idchk"></c:url>
			var url = "${idchk}?cmd=idCheck&userId="+$("#newId").val();
			window.location.href=url;
		}
	});
});
</script>
</head>
<body>
<center><h1>아이디 중복 확인</h1></center>
<% 
	User user = (User) request.getAttribute("result");
%>

<c:if test="${!empty(result) }">
${id }는 이미 사용중인 아이디입니다. <br>
</c:if>

<c:if test="${empty(result) }">
${id }는 사용 가능한 아이디입니다.<br>
<input type="button" id="useId" name="useId" value="사용" /><br>
</c:if>




다른 ID로 시도하려면 새로 중복 체크를 하세요.

<form action="${idchk }">
<label for ="id">아이디</label>
<input type="text" id="newId" name="newId" />
<input type="button" value="전송" name="submit" id="submit"/>
<input type="hidden" id ="checked" name="checked"/><br>
</form>
</body>
</html>