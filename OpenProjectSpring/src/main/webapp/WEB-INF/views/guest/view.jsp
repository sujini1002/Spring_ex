<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest Book</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div style="border: 1px soilid #000000">
<h1>${id}</h1>
<h4>${message.userId}</h4>
<h4>${message.message}</h4>
</div>
<a href="<%=request.getContextPath() %>/guest/list">되돌아가기</a>
</body>
</html>