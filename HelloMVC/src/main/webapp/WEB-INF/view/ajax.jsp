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
		
	document.querySelector("#addComment").addEventListener("click", function() {
		xhr.onreadystatechange = function() {
			if (xhr.readyState==4 && xhr.status==200) {
				document.querySelector("#boardList").innerHTML+=xhr.responseText+"<br>";
			}
		}
		
		var url = "<%=request.getContextPath()%>/ajax";
		xhr.open("post", url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("msg="+document.querySelector("#msg").value);
		
		//보내고 난 후 reset
		$("#msg").val("");
	});
	
}

</script>
</head>
<body>
<textarea rows="1" cols="50" id="msg"></textarea>
<input type="button" value="글 추가" id="addComment" name="addComment" />

<div id="boardList"></div>
</body>
</html>