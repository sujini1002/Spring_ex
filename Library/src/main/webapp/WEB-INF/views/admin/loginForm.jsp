<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<form class="formLogin" method="post">
	<div class="alert alert-light">
		<h1 class="h3 mb-4 font-weight-normal">관리자 로그인</h1>
		<h1>${msg}</h1>
		<div class="form-group">
			<label>아이디</label><select class="form-control form-control-lg"
				name="admin_id">
				<c:forEach var="item" items="${adminIds}">
					<option value="${item}">${item}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label>비밀번호</label><input type="password" name="password"
				class="form-control form-control-lg" placeholder="Password"
				required="required" autofocus="autofocus">
		</div>
		<button class="btn btn-lg btn-dark btn-block" type="submit">로그인</button>
	</div>
</form>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>