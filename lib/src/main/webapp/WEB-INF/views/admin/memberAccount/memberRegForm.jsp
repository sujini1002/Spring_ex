<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>

<form method="post">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-default">아이디</span>
		</div>
		<input type="text" class="form-control">
		<div class="input-group-prepend">
			<span class="input-group-text" id="group_password">비밀번호</span>
		</div>
		<input type="text" class="form-control"
			aria-describedby="group_passwordt">
	</div>
</form>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>