<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="${pageContext.request.contextPath}">Library</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/home">Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/adminAccount">1관리자
					계정 제어 관련 기능</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/notice">2공지사항 게시판
					접근 기능</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/book">3도서 등록/삭제
					기능</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/borrow">4도서 대출 관련
					기능</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/memberAccount">5회원 관련 기능</a></li>
		</ul>
		<a href="${pageContext.request.contextPath}/admin/logout">
			<button type="button" class="btn btn-dark">로그아웃</button>
		</a>
	</div>
</nav>
<main role="main" class="container">