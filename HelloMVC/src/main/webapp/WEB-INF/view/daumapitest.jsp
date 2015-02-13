<%@page import="sooyeon.mvc.service.DaumOpenAPIService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@ page import="java.util.*"%>
<%@ page import="net.sf.json.JSONObject"%>
<%@ page import="net.sf.json.util.JSONBuilder"%>
<%@ page import="net.sf.json.JSONArray"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
String q = request.getParameter("q")==null?"2012":request.getParameter("q");
String pageno = request.getParameter("pageno")==null?"1":request.getParameter("pageno");
String result = request.getParameter("result")==null?"":request.getParameter("result");
String output = request.getParameter("output")==null?"":request.getParameter("output");


String key = "837ec14c288f69ef9955fc6d8917c9ba";
DaumOpenAPIService service = new DaumOpenAPIService(key);

String movieItem = service.getMovieInfo(true, "2012");

//json
ObjectMapper mapper = new ObjectMapper();
HashMap<String, Object> movieResult = mapper.readValue(movieItem, HashMap.class);

request.setAttribute("movieResult", movieResult);

%>
	<table border="1">
		<tr>
			<td>검색어</td>
			<td>영화명(영문)</td>
			<td>감독(국문)</td>
			<td>줄거리</td>
			<td>포스터</td>
		</tr>


		<c:if test="${not empty movieResult.channel }">
			<c:forEach items="${movieResult.channel }"
				var="item">
				<tr>
					<td><c:out value="${item.q }" /></td>
					<td><c:out value="${item.eng_title }" /></td>
					<td><c:out value="${item.director }" /></td>
					<td><c:out value="${item.story}" /></td>
					<td><c:out value="${item.thumbnail }" /></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>
