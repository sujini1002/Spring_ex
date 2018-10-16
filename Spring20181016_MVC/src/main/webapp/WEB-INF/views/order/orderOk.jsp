<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품확안</title>
</head>
<body>
	<h1>구매 완료</h1>
	<h3>아이템 목록</h3>
	
	<ul>
		<c:forEach var="item" items="${orderCommand.orderItems}">
		<li>${item.itemId}/${item.number}/${item.remark}</li>
		</c:forEach>
		
	</ul>
	<h3>배송지</h3>
		${orderCommand.address}
</body>
</html>