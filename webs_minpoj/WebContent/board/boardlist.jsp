<%@page import="com.sooyeon.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

window.onload=function() {
	//서버가 주고받기 위해 xmlhttprequest사용
	var xhr = new XMLHttpRequest();
	<%-- // 일정시간마다 실행되는 함수, 단위 ms
	setInterval(function() {
		//서버의 응답이 준비되었을 때 처리할 동작
		//4하고 200은 지정되어있는 것(준비되었다는 의미)
		xhr.onreadystatechange = function() {
			if (xhr.readyState==4&&xhr.status==200) {
				document.querySelector("#drophere").innerHTML+=xhr.responseText+"<br>";
			}
		}
		var url = "<%=request.getContextPath()%>/FrontServlet" --%>
		
	document.querySelector("#addComment").addEventListener("click", function() {
		xhr.onreadystatechange = function() {
			if (xhr.readyState==4 && xhr.status==200) {
				document.querySelector("#boardlist").innerHTML+=xhr.responseText+"<br>";
				alert("전송 완료");
			}
		}
		<% User user = (User)session.getAttribute("user"); %>
		var url = "<%=request.getContextPath() %>/servlet/FrontServlet?cmd=addComment";
		alert(url);
		xhr.open("post", url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		var comment = document.querySelector("#comment").value;
		alert(comment);
		xhr.send("comment="+comment);
	});
	
	
}

</script>
</head>
<body>
<jsp:include page="/main/header.jsp"></jsp:include>
<hr>
<!-- 글 목록 보여주기 -->
<h1>게시판</h1>
<div id="boardlist"></div>

<!-- 글 입력칸 -->
<textarea rows="4" cols="200" id="comment"></textarea>

<!-- 글 추가버튼 -->

<input type="button" value="글 추가" id="addComment" name="addComment" />

<hr>
<jsp:include page="/main/footer.jsp"></jsp:include>
</body>
</html>