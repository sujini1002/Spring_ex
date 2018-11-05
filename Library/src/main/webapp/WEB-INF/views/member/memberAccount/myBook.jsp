<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">나의 책</h1>
<hr class="my-4">
<c:choose>
	<c:when test="${empty mybookList}">

		<p>대출 중인 책이 없습니다.</p>

	</c:when>
	<c:otherwise>
		<table class="jc_table" style="width: 100%;">
			<tr>
				<th style="width: 50%;">책 이름</th>
				<th style="width: 20%;">대출 일자</th>
				<th style="width: 20%;">반납 기한</th>
				<th style="width: 10%;">연기 신청</th>
			</tr>
			<c:forEach var="item" items="${mybookList}">
				<tr>
					<td>${item.book_name}</td>
					<td>${item.borrowDate}</td>
					<td>${item.returnDate}</td>
					<td><button onclick="test('${item.book_code}')" class="btn btn-warning" <c:if test="${item.extension == -1 or item.extension == 1}"> disabled </c:if>> 연기 신청</button></td>
				</tr>
			</c:forEach>
		</table>
		<script>
			function test(code) {

                var a = confirm('연기 신청하시면 관리자가 승인 할때까지 기다려야합니다.');
                if(a){
                    window.location.href='${pageContext.request.contextPath}/member/memberAccount/extension?book_id='+code;
                }
            }
		</script>
	</c:otherwise>

</c:choose>

<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>