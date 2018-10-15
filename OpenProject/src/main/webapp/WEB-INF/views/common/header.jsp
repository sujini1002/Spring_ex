<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 class="title">OpenProject</h1>
<ul id="gnb">
	<li><a href="<%=request.getContextPath() %>">HOME</a></li>
    <li><a href="<%=request.getContextPath() %>/member/memberReg">회원가입</a></li>
    <li><a href="<%=request.getContextPath() %>/member/login">로그인</a></li>
    <li><a href="<%=request.getContextPath() %>/mypage/mypage.jsp">마이페이지</a></li>
    <li><a href="<%=request.getContextPath() %>/memberlist.jsp">회원리스트</a></li>
</ul>

