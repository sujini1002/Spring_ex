<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">공지사항</h1>
<hr class="my-4">
<style>
    a {
        color: #999;
        text-decoration: none;
    }

    a:link {
        color: #999;
        text-decoration: none;
    }

    a:hover {
        text-decoration: none;
    }

    a:visited {
        color: #999;
        text-decoration: none;
    }

</style>
<table class="jc_table" width="100%">
    <tr>
        <th width="80">번호</th>
        <th>제목</th>
        <th width="150">이름</th>
        <th width="210">날짜</th>
    </tr>
    <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.bId}</td>
            <td><a
                    href="${pageContext.request.contextPath}/admin/notice/viewLink?bId=${dto.bId}">${dto.bTitle}</a>
            </td>
            <td>${dto.bName}</td>
            <td>${dto.bDate}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}/admin/notice/write">
    <button
            type="button" class="btn btn-dark">글 작성
    </button>
</a>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>