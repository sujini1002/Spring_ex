<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 반납</h1>
<hr class="my-4">

<div id="formchange">
    <form method="post">
        <input class="inputtext width_400" type="text" name="book_code" placeholder="북코드를 입력해주세요">
        <button class="color3_btn custom_btn" type="submit"><i class="fas fa-check-circle"></i></button>
    </form>
</div>

<c:if test="${!(empty msg)}">
    <div class="div_color5 width_400">
        <c:if test="${!(empty username)}">
            <p > ${username} 님 </p>
        </c:if>
        <p >${msg}</p>
    </div>
</c:if>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>

