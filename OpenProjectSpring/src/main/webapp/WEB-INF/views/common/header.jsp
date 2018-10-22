<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.openproject.openproject.model.MemberInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="title">OpenProject</h1>
<ul id="gnb">
	<li><a href="<%=request.getContextPath() %>">HOME</a></li>
    <li><a href="<%=request.getContextPath() %>/member/memberReg">회원가입</a></li>
    <%-- <c:set var="loginMember" value="${loginInfo}"></c:set>
    <c:if test="${loginMember.isEmpty()}">
    	<li><a href="<%=request.getContextPath() %>/member/login">로그인</a></li>
    </c:if>
    <c:if test="${!loginMember.isEmpty()}">
    	<li><a href="<%=request.getContextPath() %>/member/logout">로그아웃</a></li>
    </c:if> --%>
    <% 
    	MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");
    	if(loginInfo == null){
    %>
    <li><a href="<%=request.getContextPath() %>/member/login">로그인</a></li>
    <%} else { %>
    <li><a href="<%=request.getContextPath() %>/member/logout">로그아웃</a></li>
    <%} %> 
    <li><a href="<%=request.getContextPath() %>/member/mypage">마이페이지</a></li>
    <li><a href="<%=request.getContextPath() %>/member/list">회원리스트</a></li>
    <li><a href="<%=request.getContextPath() %>/guest/list">방명록</a></li>
</ul>

