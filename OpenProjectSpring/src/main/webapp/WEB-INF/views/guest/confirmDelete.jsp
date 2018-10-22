<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GuestBook</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1>삭제 확인</h1>
	<form  method="post">
		<input type="hidden" name="messageId"
			value="${mId}" /> 메시지를 삭제하시려면 암호를
		입력하세요:<br /> 암호: <input type="password" name="password" /> <br /> <input
			type="submit" value="메시지 삭제하기" />
	</form>
</body>
</html>