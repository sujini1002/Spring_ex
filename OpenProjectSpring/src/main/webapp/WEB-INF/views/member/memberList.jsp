<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open Project</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이미지</td>
			<td>수정/삭제</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.userId}</td>
				<td>${item.userPw}</td>
				<td>${item.userName}</td>
				<td><img
					src="<%=request.getContextPath()%>/uploadfile/userphoto/${item.userPhoto}"
					width="100px" height="100px"></td>
				<td>
					<c:if test="${loginInfo.userId eq item.userId}"> 
						<a href="update?id=${item.userId}">[수정]</a>
						<a href="delete?id=${item.userId}">[삭제]</a>
					 </c:if> 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>