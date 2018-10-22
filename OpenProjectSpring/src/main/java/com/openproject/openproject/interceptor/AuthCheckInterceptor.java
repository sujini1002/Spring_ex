package com.openproject.openproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter	{
	
	//source-Override/implements Methods 에서 생성한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션에 로그인 정보 유뮤 확인 →  return true; : 정상적인  Controller실행
		HttpSession session = request.getSession(false);
		//HttpSession session = (HttpSession) request.getSession(false).getAttribute("loginInfo");
		if(session !=null) {
			Object obj = session.getAttribute("loginInfo");
			if(obj != null) {
				return true;
			}
		}
		//잘못처리시에
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}
	
}
