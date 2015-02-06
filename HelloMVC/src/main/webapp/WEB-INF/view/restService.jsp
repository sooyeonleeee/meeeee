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
	
	String targetDt = request.getParameter("targetDt")==null?"20120101":request.getParameter("targetDt");
	String itemPerPage = request.getParameter("itemPerPage")==null?"10":request.getParameter("itemPerPage");
	String multiMovieYn = request.getParameter("multiMovieYn")==null?"":request.getParameter("multiMovieYn");
	String repNationCd = request.getParameter("repNationCd")==null?"":request.getParameter("repNationCd");
	String wideAreaCd = request.getParameter("wideAreaCd")==null?"":request.getParameter("wideAreaCd");

	String key = "837ec14c288f69ef9955fc6d8917c9ba";
	KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
	
	String dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);
	
	ObjectMapper mapper = new ObjectMapper();
	HashMap<String, Object> dailyResult = mapper.readValue(dailyResponse, HashMap.class);
	
	request.setAttribute("dailyResult", dailyResult);
	
	String codeResponse = service.getComCodeList(true, "0105000000");
	HashMap<String, Object> codeResult = mapper.readValue(codeResponse, HashMap.class);
	request.setAttribute("codeResult", codeResult);

%>

</body>
<table border="1">
	<tr>
		<td>순위</td>
		<td>영화명</td>
		<td>개봉일</td>
		<td>매출액</td>
		<td>매출액점유율</td>
		<td>매출액증감(전일대비)</td>
		<td>누적매출액</td>
		<td>관객수</td>
		<td>관객수증감(전일대비)</td>
		<td>누적관객수</td>
		<td>스크린수</td>
		<td>상영횟수</td>
	</tr>


	<c:if
		test="${not empty dailyResult.boxOfficeResult.dailyBoxOfficeList }">
		<c:forEach items="${dailyResult.boxOfficeResult.dailyBoxOfficeList }"
			var="boxoffice">
			<tr>
				<td><c:out value="${boxoffice.rank }" /></td>
				<td><c:out value="${boxoffice.movieNm }" /></td>
				<td><c:out value="${boxoffice.openDt }" /></td>
				<td><c:out value="${boxoffice.salesAmt }" /></td>
				<td><c:out value="${boxoffice.salesShare }" /></td>
				<td><c:out value="${boxoffice.salesInten }" />/<c:out value="${boxoffice.salesChange }"/></td>
				<td><c:out value="${boxoffice.salesAcc }" /></td>
				<td><c:out value="${boxoffice.audiCnt }" /></td>
				<td><c:out value="${boxoffice.audiInten }" />/<c:out value="${boxoffice.audiChange }"/></td>
				<td><c:out value="${boxoffice.audiAcc }" /></td>
				<td><c:out value="${boxoffice.scrnCnt }" /></td>
				<td><c:out value="${boxoffice.showCnt }" /></td>

			</tr>
		</c:forEach>
	</c:if>
</table>
</html>