<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 관리 : 삭제</h1>
<hr class="my-4">
<form method="post">
	<select name="searchWord" class="jc_select_left selectfont">
		<option value="title" seleted>책제목</option>
		<option value="author">작가명</option>
		<option value="publisher">출판사</option>
		<option value="isbn">ISBN번호</option>
		<option value="bookcode">책코드</option>
	</select>
	<!-- <input type="text" name="optionCode"> -->
	<input type="text" name="keyword" class="inputtext_color4"
		style="border-radius: 0px 7px 7px 0px; width: 78%" /> <input
		type="submit" value="검색" class="color4_btn custom_btn"
		style="width: 9%">
</form>
<hr>
<c:if test="${bookList.isEmpty()}">
	<h1>해당 도서를 찾을 수 없습니다.</h1>
</c:if>
<c:if test="${!bookList.isEmpty()}">
	<table class="jc_table">
		<tbody id="bookListView">
			<c:forEach var="item" items="${bookList}">
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
				<tr>
					<td rowspan="2"><img src="${item.book_image}" alt="이미지 없음">
					</td>
					<td rowspan="3" width="800">${item.book_name}</td>
					<td width="200">${item.book_writer}</td>
					<td width="300">${item.book_code}</td>
					<td width="200"><c:if test="${item.book_exist eq 0}">
							<b>대출 중인 도서입니다.</b>
						</c:if> <c:if test="${item.book_exist eq 1}">
							<%-- <input type="button" value="삭제"
								onclick="deleteBook('${item.book_code}')"> --%>
							<button type="submit" class="color3_btn btn"
								onclick="deleteBook('${item.book_code}')" style="color: white">
								<i class="fas fa-book"></i> 삭제
							</button>
						</c:if></td>
				</tr>
				<tr>
					<td width="200">${item.book_price}</td>
					<td width="200">${item.book_publisher}</td>
					<td width="200">${item.book_isbn}</td>
				</tr>
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach var="num" begin="1" end="${totalPageNum}">
	<h5 id="pageDiv" style="float:left">
			<a href="${pageContext.request.contextPath}/admin/book/searchDeleteBook?page=${num}" class="pageNum">[${num}]</a>
	</h5>
	</c:forEach>
	<br>
</c:if>

<script>
	function deleteBook(code) {

		console.log(code);
		$
				.ajax({
					url : '${pageContext.request.contextPath}/admin/book/bookDelete?book_code='
							+ code,
					type : 'GET',
					contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						alert('삭제하였습니다.');
						var bookListView = '';
						var url = '${pageContext.request.contextPath}/admin/book/bookDelete';
						var cnt = 0;
						$.each(data,function(index, item) {

											var exist = '';
											if (item.book_exist == 1) {
												exist = '<button type="submit" class="color3_btn btn"';
												exist += 'onclick="deleteBook(\''+item.book_code+'\')" style="color: white" value="삭제">';
												exist += '<i class="fas fa-book"></i> 삭제'
											    exist += '</button>';

											} else {
												exist = '<b>현재 대출 중인 도서 입니다.</b>'
											}

											bookListView += '<tr><td colspan="5" width="100%" bgcolor="pink"></td></tr>';
											bookListView += '<tr><td rowspan="2"><img src="'+item.book_image+'" alt="이미지 없음"> </td>';
											bookListView += '<td rowspan="3" width="800">'
													+ item.book_name + '</td>';
											bookListView += '<td width="200">'
													+ item.book_writer
													+ '</td>';
											bookListView += '<td width="300">'
													+ item.book_code + '</td>';
											bookListView += '<td width="200">'
													+ exist + '</td></tr>';
											bookListView += '<tr><td width="200">'
													+ item.price
													+ '</td><td width="200">'
													+ item.book_publisher
													+ '</td>';
											bookListView += '<td width="200">'
													+ item.book_isbn + '</td>';
											bookListView += '</tr>'
											bookListView += '<tr><td colspan="5" width="100%" bgcolor="pink"></td></tr>';
											cnt++;
										});
						//$('.pageNum').html('');
						$('#bookListView').html(bookListView);
						//페이징 처리
						console.log('cnt'+cnt);
						var tpageNum = cnt%10==0?cnt/10:cnt/10+1;
						var pageHtml = '';
						for(var i=1;i<=tpageNum;i++){
							pageHtml += '<a href="${pageContext.request.contextPath}/admin/book/searchDeleteBook?page='+i+'" class="pageNum">['+i+']</a>';
						};
						$('#pageDiv').html(pageHtml);
					},
					error : function() {
						alert('오류발생');
					}
				});
	}
</script>
<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>


