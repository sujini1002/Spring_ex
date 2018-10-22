package com.openproject.openproject.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.openproject.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	@Autowired
	private MemberLoginService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm(String pageNO) { // int는 null값이 들어 올 수 없다.
		return new ModelAndView("member/loginForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "password", required = false) String password,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginFail");

		try {
			if (userId != null && password != null) {
				if (service.login(userId, password, session)) {
					modelAndView.setViewName("member/mypage"); // 로그인 성공 시 mypage로 이동
				}
			}
		} catch (SQLException e) {
			modelAndView.setViewName("member/loginFail");
		}

		return modelAndView;

	}
}
