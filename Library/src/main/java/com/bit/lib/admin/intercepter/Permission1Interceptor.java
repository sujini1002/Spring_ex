package com.bit.lib.admin.intercepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.lib.admin.model.AdminVO;

public class Permission1Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {

		HttpSession session = request.getSession(false);

		AdminVO av = (AdminVO) session.getAttribute("adminLoginInfo");

		if (av.getPermission().substring(0, 1).equals("T")) {

			return true;
		}
		response.sendRedirect(request.getContextPath() + "/admin/accessDenied");

		return false;
	}

}
