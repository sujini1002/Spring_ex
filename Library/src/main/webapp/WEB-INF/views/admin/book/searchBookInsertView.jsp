<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<!-- 이곳이 body -->
<hr class="my-4">
<h1 class="page_title color5">도서 관리 : 등록</h1>
<hr class="my-4">
<form method="post">
	<select name="optionCode" class="jc_select_left selectfont">
		<option value="title" seleted>책제목</option>
		<option value="author">작가명</option>
		<option value="publisher">출판사</option>
	</select> <select class="jc_select_right selectfont" name="listCnt">
		<option value="10" seleted>10개씩</option>
		<option value="15">15개씩</option>
		<option value="20">20개씩</option>
		<option value="30">30개씩</option>
		<option value="40">40개씩</option>
	</select> <input type="text" class="inputtext_color4"
		style="margin-left: -6px; border-radius: 0px 7px 7px 0px; width: 65%"
		name="keyword" required />
	<button type="submit" class="color4_btn custom_btn" style="width: 9%">
		<i class="fas fa-search"></i>
	</button>
</form>
<span id="msg"></span>
<hr>
<c:if test="${bookList.isEmpty()}">
	<h1>해당결과를 찾을 수 없습니다.</h1>
</c:if>
<c:if test="${!bookList.isEmpty()}">
	<table class="jc_table">
		<c:forEach var="item" items="${bookList}">
			<form
				action="${pageContext.request.contextPath}/admin/book/bookInsert"
				method="post">
				<tr>
					<td rowspan="2"><img src="${item.book_image}"> <input
						type="hidden" name="book_image" value="${item.book_image}"></td>
					<td rowspan="2" width="800">${item.book_name} <input
						type="hidden" name="book_name" value="${item.book_name}">
					</td>
					<td width="200">${item.book_writer} <input type="hidden"
						name="book_writer" value="${item.book_writer}">
					</td>
					<td width="300"><input type="text" class="form-control"
						name="book_code" placeholder="북코드입력" onblur="checkBookCode(this);"
						required></td>
					<td width="200" class="td_middle">
						<button id="insertBtn" type="submit" class="color3_btn btn" style="color: white">
							<i class="fas fa-book" id=""></i> 등록
						</button>

					</td>
				</tr>
				<tr>
					<td width="200">${item.book_price} <input type="hidden"
						name="book_price" value="${item.book_price}">
					</td>
					<td width="200">${item.book_publisher} <input type="hidden"
						name="book_publisher" value="${item.book_publisher}">
					</td>
					<td width="200">${item.book_isbn} <input type="hidden"
						name="book_isbn" value="${item.book_isbn}">
					</td>
				</tr>
				<tr>
					<td colspan="5">${item.description}</td>
				</tr>
				<tr>
					<td colspan="5" width="100%" bgcolor="pink"></td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<br>
</c:if>
<script>
	function checkBookCode(code) {
		$.ajax({
					url : '${pageContext.request.contextPath}/admin/book/bookCodeCheck?book_code='
							+ code.value,
					type : 'GET',
					contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						$('#msg').html(data.resultMsg);
						if(code.value == ""){
							$('#insertBtn').attr("disabled","disabled");
							$('#msg').html('공백은 불가능 합니다!');
						}else if(data.resultCnt == "1"){
							$('#insertBtn').attr("disabled","disabled");
						}
						else{
							$('#insertBtn').removeAttr("disabled");
						}
						// alert(data.result);
					},
					error : function() {
						alert('오류발생');
					}
				});
	}
	//주석
</script>
<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>

