<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 대출/반납</h1>
<hr class="my-4">

<div class="container text-center">
<a href="borrow/membersearch"><button class="color4_btn custom_btn btn_borrow"><i class="fab fa-stack-overflow fa-flip-horizontal"></i> 책 대출</button></a>
<a href="return/home"><button  class="color4_btn custom_btn btn_borrow"><i class="fab fa-stack-overflow"></i> 책 반납</button></a>
    <a href="borrow/extension"><button  class="color4_btn custom_btn btn_borrow" style="width: 250px"><i class="fas fa-clock"></i> 기간 연장 <span class="badge badge-secondary badge-pill">${count}</span></button></a>
</div>
<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>
