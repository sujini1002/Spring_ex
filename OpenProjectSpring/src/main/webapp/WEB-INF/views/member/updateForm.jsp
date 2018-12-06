<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OpenProject</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<h1>회원 수정</h1>
	<table border="1">
		<form method="post" enctype="multipart/form-data">
		<tr>

			<td>아이디</td>
			<td><input type="text" name="userId" value="${memberInfo.userId}" readonly></td>

		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw" value="${memberInfo.userPw}"></td>

		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" value="${memberInfo.userName}"></td>

		</tr>
		<tr>
			<td>회원사진</td>
			<td><input type="file" name="userImg"></td>

		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>