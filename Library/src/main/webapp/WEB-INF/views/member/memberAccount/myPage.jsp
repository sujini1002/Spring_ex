<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">나의 정보</h1>
<hr class="my-4">
<form>
	<div class="alert alert-light">
		<table class="jc_table"
			style="border-bottom: 2px solid #547980; border-top: 2px solid #547980; width: 100%;">
			<tr>
				<th style="width: 10%;">아이디</th>
				<td style="width: 25%;">${memberLoginInfo.member_id}</td>
				<th style="width: 5%;" rowspan="3">요약</th>
				<td style="width: 60%;" rowspan="3">${memberLoginInfo.name}님은<br>
					현재까지 <b>${memberLoginInfo.totborrowDays}일</b> 동안 책을 빌리셨습니다.<br>현재까지의
					총 연체일은 <b>${memberLoginInfo.totoverduedays}일</b>입니다!<br> <c:choose>
						<c:when test="${'POSSIBLE' eq memberLoginInfo.possibledate}">
                            현재 대여 가능한 책은 <b>${memberLoginInfo.availAmount}권</b>입니다.
                        </c:when>
						<c:otherwise>
                            ${memberLoginInfo.name}님은 연체로 인해 현재 대여가 불가능한 상태입니다!<br>대출은 ${memberLoginInfo.possibledate}일부터 가능합니다.
                        </c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${memberLoginInfo.name}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${memberLoginInfo.phone}</td>
			</tr>
		</table>
		<div style="text-align: center; width: 100%; padding-top: 20px;">
			<a
				href="${pageContext.request.contextPath}/member/memberAccount/editMember?member=${memberLoginInfo.member_id}">
				<div class="color3_btn custom_btn">
					<i class="fas fa-user-edit"></i> 나의 정보 수정
				</div>
			</a>
		</div>
	</div>
</form>

<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>