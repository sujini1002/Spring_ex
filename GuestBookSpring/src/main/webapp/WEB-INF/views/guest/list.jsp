<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuestBook</title>
<style>
ul {
	list-style: none;
}
</style>
</head>
<body>
	<h1>방명록</h1>
	<a href="write">메세지 남기기</a>
	
	<c:if test="${!listView.isEmpty()}">
		<c:forEach var="message" items="${listView.messageList}">
			<div>
			<ul>
				<li>${message.id}</li>
				<li>${message.guestName}</li>
				<li>${message.message}</li> <a href="delete?id=${message.id}">[삭제하기]</a>
			</div>
			</ul>
		</c:forEach>
		<c:forEach var="num" begin="1" end="${listView.pageTotalCount}">
			<a href="list?page=${num}">[${num}]</a>
		</c:forEach>
	</c:if>
</body>
</html>