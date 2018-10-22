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
<h1>회원만 작성할 수 있습니다.</h1>
<a href="<%=request.getContextPath() %>/member/memberReg">[회원가입]가기</a>
</body>
</html>