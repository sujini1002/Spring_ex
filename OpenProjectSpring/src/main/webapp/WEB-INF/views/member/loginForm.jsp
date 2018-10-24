<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.Cookie" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/default.css">

</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div id="contents">
<h2>로그인</h2>
<hr>
<form  method="post">
    <table>
        <tr>
            <td>아이디</td>
    
           <td><input type="text" name="userId"/></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
        	<td  align="left"><input type="checkbox" name="id_save" value="save">아이디저장</td>
            <td  align="right"><input type="submit" value="로그인"></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>