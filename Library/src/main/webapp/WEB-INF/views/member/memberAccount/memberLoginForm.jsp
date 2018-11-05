<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
<form class="formLogin" method="post">
	<div class="alert alert-light">
		<h1 class="h3 mb-4 font-weight-normal">회원 로그인</h1>
		<div class="form-group">
			<label>아이디</label><input type="text" name="member_id"
				class="form-control form-control-lg" placeholder="ID"
				required="required" autofocus="autofocus">
		</div>
		<div class="form-group">
			<label>비밀번호</label><input type="password" name="password"
				class="form-control form-control-lg" placeholder="Password"
				required="required" autofocus="autofocus">
		</div>
		<button class="btn btn-lg btn-dark btn-block" type="submit">로그인</button>
	</div>
</form>
<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>