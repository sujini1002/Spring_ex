<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


게임검색 <br>
최금에 많이 플레이한 게임 : 
<c:forEach var="item" items="${gameList}">
${item}/
</c:forEach><br>
검색타입
<select>
	<c:forEach var = "item" items="${searchType}">
		<option>${item}</option>
	</c:forEach>	
</select>
<input type="text">
</body>
</html>