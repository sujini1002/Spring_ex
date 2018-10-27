<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<h1>여기는 유저를 검색합니다.</h1>
<form method="post">
    <input type="text" name="member_id">
    <input type="submit" value="검색">
</form>
<c:if test="${!(empty memberList)}">
    <table>
        <tr>
            <td> id</td>

        </tr>
        <c:forEach var="member" items="${memberList}">
            <tr>
                <td>
                    <a href="book?id=${member.member_id}">${member.member_id}</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>

