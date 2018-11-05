<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<!-- 네비 사용 시작  -->
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">
	<c:choose>
		<c:when test="${'' eq keyword}">전체 도서 목록</c:when>
		<c:otherwise>"${keyword}"의 검색결과</c:otherwise>
	</c:choose>
</h1>
<hr class="my-4">

<form id="bookOrder" name="bookOrder" class="form-inline my-2 my-lg-0">
	<select  name="searchWord" class="custom-select">
		<option value="title" seleted>책제목</option>
		<option value="author">작가명</option>
		<option value="publisher">출판사</option>
		<option value="isbn">isbn번호</option>
		<option value="bookcode">책코드</option>
	</select> <select name="orderBy"  class="custom-select">
		<option value="book_time" seleted>최신순</option>
		<option value="book_name">책제목</option>
		<option value="book_writer">작가명</option>
		<option value="book_publisher">출판사</option>
	</select> <select name="listCnt"  class="custom-select">
		<option value="5" seleted>5개씩</option>
		<option value="10">10개씩</option>
		<option value="15">15개씩</option>
		<option value="20">20개씩</option>
	</select>
	<!-- <input type="text" name="keyword" -->
	<input type="text" class="form-control mr-sm-2" name="keyword"
		id="keyword" value="${keyword}" />
	<!-- <input type="button" onclick="bookOrderFn()" value="검색"> -->
	<input type="button" class="btn btn-dark mr-sm-2" onclick="bookOrderFn()"  value="검색"/>
		<!-- <i class="fas fa-search"></i> 검색 -->

</form>
<br>
<c:if test="${bookList.isEmpty()}">
	<h3>해당결과글 찾을 수 없습니다.</h3>
</c:if>
<c:if test="${!bookList.isEmpty()}">
	<table
		style="border-bottom: 2px solid #547980; border-top: 2px solid #547980; width: 100%;">
		<tbody id="bookListView" class="jc_table">
			<c:forEach var="item" items="${bookList}">
				<form
					action="${pageContext.request.contextPath}/member/book/bookView"
					method="post">
				<tr>
					<td rowspan="2" width="90"><img src="${item.book_image}"
						alt="이미지 없음"></td>
					<td>${item.book_name}</td>

					<td width="170">${item.book_code}</td>
					<td width="150"><button type="submit" class="color3_btn btn"
							style="color: white">
							<i class="fas fa-book"></i> 상세보기
						</button></td>
				</tr>
				<tr>
					<td>${item.book_writer}</td>
					<td>${item.book_publisher}</td>
					<td>${item.book_isbn}<input type="hidden" name="book_isbn"
						value="${item.book_isbn}"></td>
				</tr>
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
				</form>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach var="num" begin="1" end="${bookCount}">
			<a href="${pageContext.request.contextPath}/member/book/searchBook?keyword=${keyword}&nowPageNum=${num}" class="pageNum">[${num}]</a>
	</c:forEach>
</c:if>

<script>
	/* 주석 */

	$(function() {
		$("input:text").keydown(function(evt) {
			if (evt.keyCode == 13)
				return false;
		});
	});

	function bookOrderFn() {
		var value = $('#bookOrder').serialize();
		$
				.ajax({
					url : '${pageContext.request.contextPath}/member/book/bookOrderBy',
					type : 'POST',
					data : value,
					contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						console.log(data);
						var bookListView = '';
						var url = '${pageContext.request.contextPath}/member/book/bookView';
						$
								.each(
										data,
										function(index, item) {
											bookListView += '<tr><td rowspan="2" width="90"><img src="'+item.book_image+'"alt="이미지 없음"></td>';
											bookListView += '<td>'
													+ item.book_name + '</td>';
											bookListView += '<td width="170">'
													+ item.book_code + '</td>';
											bookListView += '<td width="150">';
											bookListView += '<a href="' + url
													+ '?book_isbn='
													+ item.book_isbn + '">';
											bookListView += '<button  class="color3_btn btn"';
							bookListView += 'style="color: white"><i class="fas fa-book"></i> 상세보기</button></a></td>';
											bookListView += '</tr><tr>';
											bookListView += '<td>'
													+ item.book_writer
													+ '</td>';
											bookListView += '<td>'
													+ item.book_publisher
													+ '</td>';
											bookListView += '<td>'
													+ item.book_isbn + '</td>';
											bookListView += '</tr>';
											bookListView += '<tr><td colspan="5" width="100%" bgcolor="pink"></td></tr>';

										});
						$('.pageNum').html('');
						$('#bookListView').html(bookListView);
					},
					error : function() {
						alert("오류발생");
					}
				});
	}

</script>
<hr class="my-4">
<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<!-- 네비 사용 끝 -->
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>
