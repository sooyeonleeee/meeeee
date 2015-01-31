<%@page import="com.sooyeon.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
   $("#idCheck").click(function() {
   if($("#userIdInput").val() == "") {
      alert("아이디를 입력하세요.");
      $("#userIdInput").focus();
   } else {
	   <c:url value="/servlet/FrontServlet" var="idchk"></c:url>
	   var url = "${idchk}?cmd=idCheck&userId="+$("#userIdInput").val();
        //var url = "http://localhost:9090/webs_minpoj/servlet/FrontServlet?cmd=idCheck&userId="+$("#userIdInput").val();
		window.open(url,"_blank", "width=400px height=400px");
   }  
});
});
</script>
</head>
<body>
<jsp:include page="/main/header.jsp"></jsp:include>
<hr>
<%
	User newUser = (User) session.getAttribute("user");
	String userName = "";
	String userId = "";
	String userPwd = "";
	String userEmail = "";
	String userPhone = "";
	String action="joinProcess";
	if (newUser == null) {
%>
		<h1>회원 가입</h1>
<%
	} else{
		userName = newUser.getUserName();
		userId = newUser.getUserId();
		userPwd = newUser.getUserPwd();
		userEmail = newUser.getUserEmail();
		userPhone = newUser.getUserPhone();
		action="update";
%>
		<h1>회원 정보 수정</h1>
		<%=newUser %>
			
<%
	}
%>
<hr>

* 표시 항목은 필수 입력 항목입니다.<br>
<form method="post" action="<%=request.getContextPath()%>/servlet/FrontServlet?cmd=<%=action%>">
<table>
<tr><td><label for="userName">이름</label></td>
<td><input type="text" id="userName" name="userName" value="<%=userName%>"/>*</td></tr>
<tr><td><label for="userIdInput">아이디</label></td>
<% 
	if (userId.equals("")) {
%>
	<td><input type="text" id="userIdInput" name="userId" value="<%=userId%>"/>*
<%
	} else {
%>
	<td><input type="text" id="userIdInput" name="userId" value="<%=userId%>" readonly="readonly"/>*
<%
	}
%>
<input type="button" value="중복확인" id="idCheck" name="idCheck" /></td></tr>
<tr><td><label for="userPass">비밀번호</label></td>
<td><input type="password" id="userPass" name="userPwd"/>*</td></tr>
<tr><td><label for="userPwdCheck">비밀번호 확인</label></td>
<td><input type="password" id="userPwdCheck" name="userPwdCheck"/>*</td></tr>
<tr><td><label for="userEmail">이메일</label></td>
<td><input type="text" id="userEmail" name="userEmail" value="<%=userEmail%>" /></td></tr>
<tr><td><label for="userPhone">전화번호</label></td>
<td><input type="text" id="userPhone" name="userPhone" value="<%=userPhone%>" /></td></tr>
<tr><td> <input type="submit" value="확인" id="submit" />
<input type="reset" value="새로"/></td></tr>
</table>
</form>

<hr>
<jsp:include page="/main/footer.jsp"></jsp:include>
</body>
</html>