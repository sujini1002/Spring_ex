<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/resources/common/adminHeader.jsp"></jsp:include>
<jsp:include page="/resources/common/adminNavOpen.jsp"></jsp:include>
<script type="text/javascript">
	var check = '';
	$(document).ready(function() {
		$('input:checkbox').each(function() {
			if ($(this).val() == 'T') {
				$(this).prop('checked', true);
			} else {
				$(this).prop('checked', false);
			}
		});

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
	});
</script>
<hr class="my-4">
<h1 class="page_title color5">관리자 계정 수정</h1>
<hr class="my-4">
<form method="post">
	<div class="alert alert-light">
		<div class="form-group">
			<label>아이디</label><input type="text" name="admin_id"
				class="form-control form-control-lg" value="${av.admin_id}"
				required="required" readonly="readonly" />
		</div>
		<div class="form-group">
			<label>비밀번호</label><input type="text" id="password" name="password"
				class="form-control form-control-lg" placeholder="Password"
				value="${av.password}" required="required" autofocus="autofocus" />
		</div>
		<c:choose>
			<c:when test="${'admin' eq av.admin_id}">
				<table width="100%">
					<tr>
						<td>관리자 'admin' 계정의 경우 권한을 수정할 수 없습니다.</td>
							<input type="hidden" id="permission" name="permission"
									value="${av.permission}" />
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<div class="form-group">
					<label>권한</label>
					<c:set var="permission" value="${av.permission}" />
					<c:set var="permissionSize" value="${fn:length(permission)}" />

					<div class="custom-control custom-checkbox">
						<c:set var="count" value="0" scope="page" />
						<table width="100%">
							<tr>
								<c:forEach var="item" items="${permissions}">
									<c:set var="count" value="${count+1}" scope="page" />
									<td style="padding-right: 20px;"><input type="checkbox"
										id="permission${count}"
										value="${fn:substring(permission, count-1, count)}"> <label
										for="permission${count}"> ${item}</label></td>
								</c:forEach>
								<input type="hidden" id="permission" name="permission"
									value="${av.permission}" />
							</tr>
						</table>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

		<button class="color4_btn custom_btn btn-block" style="color: #F5FFD2"
			type="submit">관리자 수정</button>
	</div>
</form>

<jsp:include page="/resources/common/adminNavClose.jsp"></jsp:include>
<jsp:include page="/resources/common/adminFooter.jsp"></jsp:include>