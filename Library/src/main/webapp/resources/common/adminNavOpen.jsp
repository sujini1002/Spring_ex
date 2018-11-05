<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav class="navbar navbar-expand-md navbar-dark color5_back fixed-top">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Library</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<c:set var="permission" value="${adminLoginInfo.permission}" />
	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/home"><i
					class="fa fa-home"> Home</i> </a></li>
			<c:if test="${'T' eq fn:substring(permission, 0, 1)}">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/adminAccount"><i class="fa fa-user-circle"></i> 관리자 
						계정 관리</a></li>
			</c:if>
			<c:if test="${'T' eq fn:substring(permission, 1, 2)}">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/notice"><i class="fa fa-clipboard"></i> 공지사항 
						</a></li>
			</c:if>
			<c:if test="${'T' eq fn:substring(permission, 2, 3)}">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/book"><i class="fa fa-book"></i> 도서 관리 </a></li>
			</c:if>
			<c:if test="${'T' eq fn:substring(permission, 3, 4)}">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/borrow"><i class="fas fa-book-reader"></i> 도서 대출/반납
						</a></li>
			</c:if>
			<c:if test="${'T' eq fn:substring(permission, 4, 5)}">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/memberAccount"><i class="fa fa-user"></i> 회원
						관리 </a></li>
			</c:if>
		</ul>
		<a href="${pageContext.request.contextPath}/admin/logout">
			<button type="button" class="btn btn-dark">로그아웃</button>
		</a>
	</div>
</nav>
<main role="main" class="container">