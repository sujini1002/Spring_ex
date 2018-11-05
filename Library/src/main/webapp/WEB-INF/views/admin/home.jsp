<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>

<c:set var="permission" value="${adminLoginInfo.permission}" />

<c:if test="${'T' eq fn:substring(permission, 0, 1)}">

	<a class="nav-link"
					href="${pageContext.request.contextPath}/admin/adminAccount">
    <button class="adminHomeBigBtn color2_btn custom_btn"><i class="fa fa-user-circle fa-fw"></i> 관리자 계정관리</button></a>
</c:if>
<c:if test="${'T' eq fn:substring(permission, 1, 2)}">
	<a class="nav-link"
					href="${pageContext.request.contextPath}/admin/notice">
		<button class="adminHomeBigBtn color2_btn custom_btn">
        <i class="fa fa-clipboard fa-fw"></i> 공지사항 작성
    </button>
	</a>
</c:if>
<c:if test="${'T' eq fn:substring(permission, 2, 3)}">
	 <a class="nav-link"
					href="${pageContext.request.contextPath}/admin/book">
		<button class="adminHomeBigBtn color3_btn custom_btn">
			<i class="fas fa-book fa-fw"></i>
			 도서 등록/삭제
		</button>
	 </a>
</c:if>
<c:if test="${'T' eq fn:substring(permission, 3, 4)}">
	<a class="nav-link"
					href="${pageContext.request.contextPath}/admin/borrow">
    <button class="adminHomeBigBtn color3_btn custom_btn"><i class="fas fa-book-reader fa-fw"></i>  도서 대출/반납</button>
    </a>
</c:if>
<c:if test="${'T' eq fn:substring(permission, 4, 5)}">
	<a class="nav-link" 
					href="${pageContext.request.contextPath}/admin/memberAccount">
    <button  class="adminHomeBigBtn color4_btn custom_btn"><i class="fa fa-user fa-fw"></i> 회원 관리</button></a>

</c:if>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>