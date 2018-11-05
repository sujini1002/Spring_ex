<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<script type="text/javascript">

	$(document).ready(function() {
		$("#phone").change(function() {
			$("#password").val($("#phone").val());
		});
		$("#member_id").keyup(function() {
			$.ajax({
				type : 'GET',
				url : "${pageContext.request.contextPath}/admin/memberAccount/memberDuplCheck?member=" + $('#member_id').val(),
				success : function(data) {
					if(data == false && $('#member_id').val() != ''){
						$('#idReg').prop("disabled", false);
						$("#msg").html(" : 사용가능한 아이디입니다.");
					} else {
						if ($('#member_id').val() == ''){
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
<h1 class="page_title color5">회원 등록</h1>
<hr class="my-4">
<form method="post">
	<div class="alert alert-light">

		<div class="form-group">
			<label>아이디</label><label id="msg"></label><input type="text" id="member_id" name="member_id"
				class="form-control form-control-lg" placeholder="ID"
				required="required" autofocus="autofocus" />
		</div>
		<div class="form-group">
			<label>비밀번호</label><input type="text" id="password" name="password"
				class="form-control form-control-lg" placeholder="초기값  : 전화번호"
				required="required" readonly="readonly" />
		</div>
		<div class="form-group">
			<label>이름</label><input type="text" id="name" name="name"
				class="form-control form-control-lg" placeholder="이름"
				required="required" autofocus="autofocus">
		</div>
		<div class="form-group">
			<label>전화번호</label><input type="text" id="phone" name="phone"
				class="form-control form-control-lg" placeholder="전화번호"
				required="required" autofocus="autofocus">
		</div>
		<!-- 초기값 -->
		<input type="hidden" name="availAmount" value="5" /> <input
			type="hidden" name="totborrowDays" value="0" /> <input type="hidden"
			name="totoverduedays" value="0" /> <input type="hidden"
			name="possibledate" value="POSSIBLE" />

		<button class="color4_btn custom_btn btn-block" style="color:#F5FFD2" type="submit" id="idReg">회원 등록</button>
	</div>
</form>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>