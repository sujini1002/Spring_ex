<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>

<hr class="my-4">
<h1 class="page_title color5">회원 관리</h1>
<hr class="my-4">
<a
	href="${pageContext.request.contextPath}/admin/memberAccount/memberReg">
	<button class="btn"><i class="fas fa-user-plus"></i> 회원 등록</button>
</a>
<table class="jc_table">
	<tr>
		<th>회원 아이디</th>
		<th>회원 비밀번호</th>
		<th>회원 이름</th>
		<th>대출 가능 권수</th>
		<th>전화번호</th>
		<th>총 대출일</th>
		<th>총 연체일</th>
		<th>대출 가능 일자</th>
		<th>수정/삭제</th>
	</tr>
	<c:forEach var="item" items="${members}">
		<tr>
			<td>${item.member_id}</td>
			<td>${item.password}</td>
			<td>${item.name}</td>
			<td>${item.availAmount}</td>
			<td>${item.phone}</td>
			<td>${item.totborrowDays}</td>
			<td>${item.totoverduedays}</td>
			<td>${item.possibledate}</td>
			<td><a
				href="${pageContext.request.contextPath}/admin/memberAccount/memberEdit?member=${item.member_id}"><button class="btn btn-warning"><i class="fas fa-user-edit"></i></button></a>
				<a
				href="${pageContext.request.contextPath}/admin/memberAccount/memberDelete?member=${item.member_id}">
				<button  type="button" class="btn btn-danger">
					<i class="fas fa-user-slash"></i>
				</button></a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>