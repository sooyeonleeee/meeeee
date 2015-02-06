<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService"%>
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
<title>Insert title here</title>
</head>
<body>
<%	
	
	String curPage = request.getParameter("curPage")==null?"1":request.getParameter("curPage");
	String itemPerPage = request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");
	String movieNm = request.getParameter("movieNm")==null?"분홍신":request.getParameter("movieNm");
	String directorNm = request.getParameter("directorNm")==null?"":request.getParameter("directorNm");
	String openStartDt = request.getParameter("openStartDt")==null?"":request.getParameter("openStartDt");
	String openEndDt = request.getParameter("openEndDt")==null?"":request.getParameter("openEndDt");
	String prdtStartYear = request.getParameter("prdtStartYear")==null?"":request.getParameter("prdtStartYear");
	String prdtEndYear = request.getParameter("prdtEndYear")==null?"":request.getParameter("prdtEndYear");
	String repNationCd = request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");
	String[] movieTypeCds = {""};
	String[] movieTypeCdArr = request.getParameterValues("movieTypeCdArr")==null?movieTypeCds:request.getParameterValues("movieTypeCdArr");

	String key = "837ec14c288f69ef9955fc6d8917c9ba";
	KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
	
	String movieItem = service.getMovieList(true, curPage, itemPerPage, movieNm, directorNm, openStartDt, openEndDt, prdtStartYear, prdtEndYear, repNationCd, movieTypeCdArr);
	
	//json
	ObjectMapper mapper = new ObjectMapper();
	HashMap<String, Object> movieResult = mapper.readValue(movieItem, HashMap.class);
	
	request.setAttribute("movieResult", movieResult);
	
	String codeResponse = service.getComCodeList(true, "0105000000");
	HashMap<String, Object> codeResult = mapper.readValue(codeResponse, HashMap.class);
	request.setAttribute("codeResult", codeResult);

%>

</body>
<table border="1">
	<tr>
		<td>영화코드</td>
		<td>영화명(국문)</td>
		<td>영화명(영문)</td>
		<td>제작연도</td>
		<td>개봉연도</td>
		<td>영화유형</td>
		<td>제작상태</td>
		<td>제작국가</td>
		<td>장르</td>
		<td>영화감독</td>
		<td>영화감독명</td>
		<td>제작사</td>
		<td>제작사코드</td>
		<td>제작사명</td>
	</tr>


	<c:if
		test="${not empty movieResult.movieListResult.movieList }">
		<c:forEach items="${movieResult.movieListResult.movieList }"
			var="movie">
			<tr>
				<td><c:out value="${movie.movieCd }" /></td>
				<td><c:out value="${movie.movieNm }" /></td>
				<td><c:out value="${movie.movieNmEn }" /></td>
				<td><c:out value="${movie.prdtYear }" /></td>
				<td><c:out value="${movie.openDt }" /></td>
				<td><c:out value="${movie.typeNm }" /></td>
				<td><c:out value="${movie.prdtStatNm }" /></td>
				<td><c:out value="${movie.nationAlt }" /></td>
				<td><c:out value="${movie.genreAlt }" /></td>
				<td><c:out value="${movie.repNationNm }" /></td>
				<td><c:out value="${movie.repGenreNm }" /></td>
				<td><c:out value="${movie.directors }" /></td>
				<td><c:out value="${movie.peopleNm }" /></td>
				<td><c:out value="${movie.companys }" /></td>
				<td><c:out value="${movie.companyCd }" /></td>
				<td><c:out value="${movie.companyNm }" /></td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</html>