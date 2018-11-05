<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 관리</h1>
<hr class="my-4">
<div class="container text-center">

	<a href="${pageContext.request.contextPath}/admin/book/searchInsertBook">
		<button class="color4_btn custom_btn btn_borrow"><i class="fas fa-plus-square"></i> 책 등록</button>
		</a>
	<a href="${pageContext.request.contextPath}/admin/book/searchDeleteBook">
		<button class="color4_btn custom_btn btn_borrow"><i class="fas fa-minus-square"></i> 책 삭제</button></a>

</div>


<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>