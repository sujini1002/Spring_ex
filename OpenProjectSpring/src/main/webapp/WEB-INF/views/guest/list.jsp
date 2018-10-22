<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuestBook</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1>방명록</h1>
	<a href="write">메세지 남기기</a>
	
	 <c:if test="${!listView.isEmpty()}">
		<c:forEach var="message" items="${listView.messageList}">
			<div>
			<ul>
				<li>${message.messageId}</li>
				<li>${message.userId}</li>
				<li>${message.message}</li>
				<a href="delete?id=${message.messageId}">[삭제하기]</a>
				<a href="view/${message.messageId}">[상세보기]</a>
			</ul>
			</div>
		</c:forEach>
		<c:forEach var="num" begin="1" end="${listView.pageTotalCount}">
			<a href="list?page=${num}">[${num}]</a>
		</c:forEach>
	</c:if> 
</body>
</html>