<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<script type="text/javascript">
	var check = '';
	$(document).ready(function() {
		$('input:checkbox').change(function() {
			check = '';
			$('input:checkbox').each(function() {
				if ($(this).is(':checked')) {
					check = check + 'T';
				} else {
					check = check + 'F';
				}
			});
			$('#permission').val(check);
		});
		
		$("#admin_id").keyup(function() {
			$.ajax({
				type : 'GET',
				url : "${pageContext.request.contextPath}/admin/adminAccount/adminDuplCheck?admin=" + $('#admin_id').val(),
				success : function(data) {
					if(data == false && $('#admin_id').val() != ''){
						$('#idReg').prop("disabled", false);
						$("#msg").html(" : 사용가능한 아이디입니다.");
					} else {
						if ($('#admin_id').val() == ''){
							$("#msg").html(" : 아이디를 입력해주세요.");
						} else{
							$("#msg").html(" : 이미 존재하는 아이디입니다.");
						}
						$('#idReg').prop("disabled", true);
					}
				},
				error : function(error) {
					console.log("error : " + error);
				}
			});
		});
	});
</script>
<hr class="my-4">
<h1 class="page_title color5">관리자 계정 등록</h1>
<hr class="my-4">
<form method="post">
	<div class="alert alert-light">

		<div class="form-group">
			<label>아이디</label><label id="msg"></label><input type="text"
				name="admin_id" id="admin_id" class="form-control form-control-lg"
				placeholder="ID" required="required" autofocus="autofocus" />
		</div>
		<div class="form-group">
			<label>비밀번호</label><input type="text" id="password" name="password"
				class="form-control form-control-lg" placeholder="Password"
				required="required" autofocus="autofocus" />
		</div>
		<div class="form-group">
			<label>권한</label>
			<div class="custom-control custom-checkbox">
				<c:set var="count" value="0" scope="page" />
				<table width="100%">
					<tr>
						<c:forEach var="item" items="${permissions}">
							<td style="padding-right: 20px;"><c:set var="count"
									value="${count+1}" scope="page" /> <input type="checkbox"
								id="permission${count}" value="T"> <label
								for="permission${count}"> ${item}</label></td>
						</c:forEach>
					<tr>
				</table>
				<input type="hidden" id="permission" name="permission" value="FFFFF" />
			</div>
		</div>
		<button class="color4_btn custom_btn btn-block" style="color: #F5FFD2"
			type="submit" id="idReg">관리자 등록</button>
	</div>
</form>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>