<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<!-- 네비 사용 시작  -->
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">${bookInfo.book_name}</h1>
<hr class="my-4">
<table class="jc_table">
	<tr>
		<td rowspan="3"><img src="${ad.cover}"></td>
		<td rowspan="2" width="800">${bookInfo.book_name}</td>
		<td width="200">${bookInfo.book_writer}</td>
		<td>${bookExist}</td>
		<td width="430"><select name="bookcode" class="form-control">

				<c:forEach var="item" items="${bookCodeList}">
					<c:choose>
						<c:when test="${item.book_exist eq 1 }">
							<option>${item.book_code}(대출가능)</option>
						</c:when>
						<c:otherwise>
							<option>${item.book_code}(대출블가능)</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td width="200">${bookInfo.book_price}</td>
		<td width="200">${bookInfo.book_publisher}</td>
		<td width="200">${bookInfo.book_isbn}</td>

	</tr>
	<tr>
		<td colspan="5">${bookInfo.description}</td>
	</tr>
	<tr>
		<td colspan="5">이 책의 평점 : <c:choose>
				<c:when test="${10 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
				</c:when>
				<c:when test="${9 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star-half-alt"></i>
				</c:when>
				<c:when test="${8 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${7 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star-half-alt"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${6 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${5 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star-half-alt"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${4 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${3 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="fas fa-star-half-alt"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${2 eq ad.customerReviewRank}">
					<i class="fas fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${1 eq ad.customerReviewRank}">
					<i class="fas fa-star-half-alt"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
				<c:when test="${0 eq ad.customerReviewRank}">
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
					<i class="far fa-star"></i>
				</c:when>
			</c:choose><br>이 책이 마음에 드셨나요? <a href="${ad.link}" target="_blank"><button
					class="btn btn-dark mr-sm-2" type="submit"
					style="margin-left: 15px;">구경가기</button></a></td>
	</tr>
	<c:if test="${0 ne ad.usedAladinUsedCount}">
		<tr>
			<td colspan="5">해당 도서의 <font style="color: red;">알라딘 직배송 중고책</font>이 ${ad.usedAladinUsedCount}권 있네요!<br>
				최저가는 ${ad.usedAladinMinPrice}원 입니다. 구경하러 가시겠어요? <a
				href="${ad.usedAladinLink}" target="_blank"><button
						class="btn btn-dark mr-sm-2" type="submit"
						style="margin-left: 15px;">구경가기</button></a>
			</td>
		</tr>
	</c:if>
	<c:if test="${0 ne ad.userUsedCount}">
		<tr>
			<td colspan="5">해당 도서의 <font style="color: red;">알라딘 회원 중고책</font>이 ${ad.userUsedCount}권 있네요!<br>
				최저가는 ${ad.userUsedMinPrice}원 입니다. 구경하러 가시겠어요? <a
				href="${ad.userUsedLink}" target="_blank"><button
						class="btn btn-dark mr-sm-2" type="submit"
						style="margin-left: 15px;">구경가기</button></a>
			</td>
		</tr>
	</c:if>
</table>

<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<!-- 네비 사용 끝 -->
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>