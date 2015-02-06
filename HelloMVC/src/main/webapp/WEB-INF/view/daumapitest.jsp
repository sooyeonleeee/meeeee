<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daum 웹 검색 API</title>
<script type="text/javascript">
	function search_movie() {
		var query = document.getElementById("query");
		var category = document.getElementById("category");
		var url = "http://apis.daum.net/contents/movie";
		url += "?q=" + query.value;
		url += "&apikey=3dcac4347f2807c4ca027e2d872a2ae5";
		location.href = url;
	}
</script>
</head>
<body>
	<form id="search_form" action="javascript:search_movie();"
		method="post">
		<input type="text" size="10" id="query" name="query" /> <input
			type="submit">
	</form>
	<div id="results"></div>
	<table border="1">
		<tr>
			<td>검색어</td>
			<td>영화명(국문)</td>
			<td>영화명(영문)</td>
			<td>감독</td>
			<td>제작연도</td>
		</tr>


		<c:if test="${not empty movieResult.movieListResult.movieList }">
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

</body>
</html>
