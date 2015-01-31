<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/main/header.jsp"></jsp:include>
	<h1>회원 가입 결과</h1><br>
	회원 가입에 성공하였습니다.<br>
	좋은 활동 부탁 드립니다.<br>
<a href="<%=request.getContextPath() %>/main/main.jsp">메인으로</a>
<jsp:include page="/main/footer.jsp"></jsp:include>
</body>
</html>