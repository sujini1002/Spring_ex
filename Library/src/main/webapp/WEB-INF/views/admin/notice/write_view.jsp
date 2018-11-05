<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<hr class="my-4">
<h1 class="page_title color5">공지사항 : 작성</h1>
<hr class="my-4">
<script>
$(document).ready(function() {
	$('#submitBtn').click(function() {
		$('#bContent').val($('#bContent').val().replace(/\n/g, '<br>'));
		$('#target').submit();
	});
});
</script>
<form method="post" id="target">
	<table class="jc_table" width="100%"
		style="border-top: 2px solid #547980; border-bottom: 2px solid #547980;">
		<tr>
			<th width="120">이름</th>
			<td>관리자<input type="hidden" value="관리자" name="bName" size="50"
				class="form-control"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="bTitle" size="50"
				class="form-control" required="required"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id="bContent" name="bContent" rows="10"
					class="form-control" required="required"></textarea><input type="text" value=""/></td>
		</tr>
	</table>
	<br> <input type="button" id="submitBtn" value="입력" class="btn btn-dark">
</form>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>