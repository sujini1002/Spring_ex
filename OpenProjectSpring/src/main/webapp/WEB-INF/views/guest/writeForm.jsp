<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest Book</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<form  method="post">
		아이디: <input type="text" name=userId value="${loginInfo.userId}" readonly/> <br /> 암호: <input
			type="password" name="password" /> <br /> 메시지:
		<textarea name="message" cols="30" row="3"></textarea>
		<br /> 
		<input type="submit" value="메시지 남기기" />
	</form>
</body>
</html>