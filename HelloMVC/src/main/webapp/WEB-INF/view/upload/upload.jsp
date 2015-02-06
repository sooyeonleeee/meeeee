<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload test</title>
</head>
<body>
<h2>파일 업로드</h2>
<form method="post" enctype="multipart/form-data"
action="<%=request.getContextPath() %>/upload">
file선택: <input type="file" name="uploadFile">
<button type="submit">upload</button>
</form>
</body>
</html>