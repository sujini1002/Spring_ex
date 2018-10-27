<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library</title>
</head>
<body>
	<form method="post">
		<select name="optionCode">
			<option value="title" seleted>책제목</option>
			<option value="author">작가명</option>
			<option value="publisher">출판사</option>
		</select>
		<!-- <input type="text" name="optionCode"> -->
		<input type="text" name="keyword" /> <input type="submit" value="검색">
	</form>
	<hr>
	<c:if test="${bookList.isEmpty()}">
		<h1>해당결과글 찾을 수 없습니다.</h1>
	</c:if>
	<c:if test="${!bookList.isEmpty()}">
		<table>
			<c:forEach var="item" items="${bookList}">
				<form action="/book/bookInsert" method="post">
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
				<tr>
					<td rowspan="2">
						<img src="${item.image}">
					</td>
					<td rowspan="3" width="800">${item.title}</td>
					<td width="200">${item.author}</td>
					<td width="300"><input type="text" name="bookCode"
						placeholder="북코드입력" requried></td>
					<td width="200"><input type="submit" value="등록"></td>
				</tr>
				<tr>
					<td width="200">${item.price}</td>
					<td width="200">${item.publisher}</td>
					<td width="200">${item.isbn}</td>
				</tr>
				<tr>
					<td colspan="5">${item.description}</td>
				</tr>
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
				</form>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>