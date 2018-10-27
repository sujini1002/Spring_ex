<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Library</title>
<link
	href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada|Nanum+Gothic|Nanum+Myeongjo|Noto+Sans+KR|Noto+Serif+KR"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body id="homeBody">
	<div id="homeContainer">
		<div id="homeContent">
			<h1 class="homeLogo color5">Library</h1>
			<h1 class="homeTitle color5">
				사람은 책을 만들고,<br>책은 사람을 만든다.
			</h1>
			<a href="${pageContext.request.contextPath}/admin/home"><input
				type="button" class="homeBigBtn color3_btn custom_btn" value="관리자"></a>
			<a href="${pageContext.request.contextPath}/member/home"><input
				type="submit" class="homeBigBtn color4_btn custom_btn" value="사용자"></a>
		</div>
	</div>
</body>
</html>
