<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/resources/common/memberHeader.jsp"></jsp:include>
<!-- 네비 사용 시작  -->
<jsp:include page="/resources/common/memberNavOpen.jsp"></jsp:include>
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
<hr class="my-4">
<h1 class="page_title color5">신간도서</h1>
<hr class="my-4">
<div style="width: 100%; margin: auto;">
	<div class="mySlides">
		<table style="width: 100%; border: none;">
			<tr>
				<td id="thumb1" width="20%"></td>
				<td id="thumb2" width="20%"></td>
				<td id="thumb3" width="20%"></td>
				<td id="thumb4" width="20%"></td>
				<td id="thumb5" width="20%"></td>
			</tr>
		</table>
		<hr class="my-4">
		<table style="width: 100%;" class="jc_table">
			<tr>
				<th>책 제목</th>
				<th>작가</th>
				<th>출판사</th>
			</tr>
			<tr>
				<td id="detail_name_1"></td>
				<td id="detail_writer_1"></td>
				<td id="detail_publisher_1"></td>
			</tr>
			<tr>
				<td id="detail_name_2"></td>
				<td id="detail_writer_2"></td>
				<td id="detail_publisher_2"></td>
			</tr>
			<tr>
				<td id="detail_name_3"></td>
				<td id="detail_writer_3"></td>
				<td id="detail_publisher_3"></td>
			</tr>
			<tr>
				<td id="detail_name_4"></td>
				<td id="detail_writer_4"></td>
				<td id="detail_publisher_4"></td>
			</tr>
			<tr>
				<td id="detail_name_5"></td>
				<td id="detail_writer_5"></td>
				<td id="detail_publisher_5"></td>
			</tr>
		</table>
	</div>
	<div class="mySlides">
		<table style="width: 100%; border: none;">
			<tr>
				<td id="thumb6" width="20%"></td>
				<td id="thumb7" width="20%"></td>
				<td id="thumb8" width="20%"></td>
				<td id="thumb9" width="20%"></td>
				<td id="thumb10" width="20%"></td>
			</tr>
		</table>
		<hr class="my-4">
		<table style="width: 100%;" class="jc_table">
			<tr>
				<th>책 제목</th>
				<th>작가</th>
				<th>출판사</th>
			</tr>
			<tr>
				<td id="detail_name_6"></td>
				<td id="detail_writer_6"></td>
				<td id="detail_publisher_6"></td>
			</tr>
			<tr>
				<td id="detail_name_7"></td>
				<td id="detail_writer_7"></td>
				<td id="detail_publisher_7"></td>
			</tr>
			<tr>
				<td id="detail_name_8"></td>
				<td id="detail_writer_8"></td>
				<td id="detail_publisher_8"></td>
			</tr>
			<tr>
				<td id="detail_name_9"></td>
				<td id="detail_writer_9"></td>
				<td id="detail_publisher_9"></td>
			</tr>
			<tr>
				<td id="detail_name_10"></td>
				<td id="detail_writer_10"></td>
				<td id="detail_publisher_10"></td>
			</tr>
		</table>
	</div>
</div>

<c:set var="count" value="0" scope="page" />
<c:forEach var="item" items="${bookList}">
	<%-- <c:forEach var="items" items="${ads}"> --%>
	<c:set var="count" value="${count + 1}" scope="page" />
	<script>
		$('#thumb${count}')
			    .html(
			        '<a href="${pageContext.request.contextPath}/member/book/bookView?book_isbn=${item.book_isbn}"><img src="${item.book_image}" style="width: 100%; padding-left: 10px; padding-right: 10px; text-align: center;" id="img${count}"></a>');
			$('#img${count}').height($('#thumb1').width() * 1.3);
			// $('#detail_name_${count}').html('${item.book_name}');
			$('#detail_name_${count}')
					.html(
							'<a href="${pageContext.request.contextPath}/member/book/bookView?book_isbn=${item.book_isbn}">${item.book_name}</a>');
			$('#detail_writer_${count}').html('${item.book_writer}');
			$('#detail_publisher_${count}').html('${item.book_publisher}');
		</script>
	<%-- ISBN/${item.book_isbn}/${fn:substring(item.book_isbn,11,24)} --%><br>
	<%-- </c:forEach> --%>
</c:forEach>
<c:set var="thumbcount" value="0" scope="page" />
<c:forEach var="items" items="${ads}">
	<c:set var="thumbcount" value="${thumbcount + 1}" scope="page" />
	<script>
		$('#img${thumbcount}').attr('src', '${items.cover}');
	</script>
</c:forEach>

<script>

	// 슬라이드 부분
	var myIndex = 0;
	carousel();

	function carousel() {
		var i;
		var x = document.getElementsByClassName("mySlides");
		for (i = 0; i < x.length; i++) {
			x[i].style.display = "none";
		}
		myIndex++;
		if (myIndex > x.length) {
			myIndex = 1
		}
		x[myIndex - 1].style.display = "block";
		setTimeout(carousel, 4000); // Change image every 2 seconds
	}
</script>



<jsp:include page="/resources/common/memberNavClose.jsp"></jsp:include>
<!-- 네비 사용 끝 -->
<jsp:include page="/resources/common/memberFooter.jsp"></jsp:include>