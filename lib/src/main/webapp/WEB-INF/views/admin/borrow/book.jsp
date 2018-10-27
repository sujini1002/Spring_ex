<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<h1>여기는 책을 진짜로 입력합니다.</h1>
<c:choose>
    <c:when test="${possible}">
        ${member.name}은 ${member.availAmount}만큼 대여 가능합니다.
        <form method="post" name="test">
            <input type="hidden" name="member.member_id" value="${member.member_id}">
            <input type="submit" value="대여">
        </form>

        <input type="text" id="booksearch" onblur="function test() {
          $.ajax({
          url:'${pageContext.request.contextPath}/admin/borrow/bookSearch?bookname=',
                datatype:'get',
                success:function(data) {
                },
                error:function () {

        }

          });
        }">



    </c:when>
    <c:otherwise>
        ${member.name}은 현재 대여 불가 상태입니다.<br/>
        ${member.availAmount}<br/>
        ${member.possibledate}까지 대여 불가임!
    </c:otherwise>
</c:choose>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>

