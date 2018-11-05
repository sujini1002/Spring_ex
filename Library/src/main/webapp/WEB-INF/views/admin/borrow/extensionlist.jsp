<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">대출 기간 연장</h1>
<hr class="my-4">
<c:if test="${!(empty list)}">
    <table class="jc_table">
        <tr>
            <th> 회원 id</th>
            <th> 책 코드</th>
            <th> 책 이름</th>
            <th> 대여일</th>
            <th>반납 예정일</th>
            <th> 승인</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>
                    ${item.member_id}
                </td>
                <td>
                        ${item.book_code}
                </td>
                <td>
                        ${item.book_name}
                </td>
                <td>
                        ${item.borrowDate}
                </td>
                <td>
                        ${item.returnDate}
                </td>
                <td>
                    <form method="post">
                        <input type="hidden" name="book_code" value="${item.book_code}">
                        <input type="hidden" name="ok" value="true">
                    <button type="submit" class="btn btn-warning"><i class="fas fa-check-circle"></i> 승인 </button></form>
                    <form method="post">
                        <input type="hidden" name="book_code" value="${item.book_code}">
                        <input type="hidden" name="ok" value="false">
                        <button type="submit" class="btn btn-danger"><i class="fas fa-check-circle"></i> 거부 </button></form>
                </td>

            </tr>
        </c:forEach>
    </table>

</c:if>
<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>
