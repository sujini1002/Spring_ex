<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-md navbar-dark color5_back fixed-top">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Library</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/member/home"><i
					class="fa fa-home"> Home</i> </a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/member/notice">공지사항</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/member/home/list">자유게시판</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0"
			action="${pageContext.request.contextPath}/member/book/searchBook"
			method="post">
			<input class="form-control mr-sm-2" type="text" placeholder="Book"
				name="keyword" aria-label="Search">
			<button class="btn btn-dark mr-sm-2" type="submit">검색</button>
		</form>
		<c:choose>
			<c:when test="${empty memberLoginInfo}">
				<a
					href="${pageContext.request.contextPath}/member/memberAccount/login">
					<button type="button" class="btn btn-dark">로그인</button>
				</a>
			</c:when>
			<c:otherwise>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="https://example.com"
						id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">${memberLoginInfo.name}님, 안녕하세요!</a>
						<div class="dropdown-menu" aria-labelledby="dropdown01">
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/member/memberAccount/myBook">나의
								책</a> <a class="dropdown-item"
								href="${pageContext.request.contextPath}/member/memberAccount/myPage">나의
								정보</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/member/memberAccount/logout">로그아웃</a>
						</div></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</nav>
<main role="main" class="container">