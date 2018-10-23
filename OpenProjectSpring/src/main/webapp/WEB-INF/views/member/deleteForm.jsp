<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open Project</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<h1>삭제 확인</h1>
	<form  method="post">
		<input type="text" name="userId"value="${userId}" readonly/> <br>
		메시지를 삭제하시려면 암호를입력하세요:<br /> 
		암호: <input type="password" name="userPw" /> <br />
		 <input type="submit" value="탈퇴하기" />
	</form>
</body>
</html>