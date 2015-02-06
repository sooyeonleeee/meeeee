<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
	document.querySelector("#search").addEventListener("click", function() {
		xhr.onreadystatechange = function() {
			if (xhr.readyState==4 && xhr.status==200) {
				document.querySelector("#result").innerHTML+=xhr.responseText+"<br>";
			}
		}
		
		var url = "<%=request.getContextPath()%>/search";
		xhr.open("post", url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("movie="+document.querySelector("#movie").value);
		
		//보내고 난 후 reset
		$("#msg").val("");
	});
	
}

</script>
</head>
<body>
<h1>영화 검색</h1>
영화 제목 : <input type="text" id="movie" />
<input type="button" value="검색" id="search" name="search" />

<div id="result"></div>

</body>
</html>