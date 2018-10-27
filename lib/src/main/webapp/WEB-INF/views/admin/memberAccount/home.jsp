<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>

<h1>회원 계정 관련 기능</h1>
<a
	href="${pageContext.request.contextPath}/admin/memberAccount/memberReg"><input
	type="button" value="회원 등록"></a>
<table>
	<tr>
		<td>회원 아이디</td>
		<td>회원 비밀번호</td>
		<td>회원 이름</td>
		<td>대출 가능 권수</td>
		<td>전화번호</td>
		<td>총 대출일</td>
		<td>총 연체일</td>
		<td>대출 가능 일자</td>
		<td>수정/삭제</td>
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
				href="${pageContext.request.contextPath}/admin/memberAccount/memberEdit?member_id=${item.member_id}"><input
					type="button" value="수정"></a><a
				href="${pageContext.request.contextPath}/admin/memberAccount/memberDelete?member_id=${item.member_id}"><input
					type="button" value="삭제"></a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>