package com.bit.lib.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/memberAccount/login")
public class MemberLoginController {

	@Autowired
	MemberLoginService memberLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMemberLoginForm(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		// 로그인 된 상태에서 로그인 페이지 접속시 처리
		if (session.getAttribute("memberLoginInfo") != null) {
			modelAndView.setViewName("/member/home");
		} else {
			modelAndView.setViewName("/member/memberAccount/memberLoginForm");
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getMemberLogin(@RequestParam("member_id") String member_id,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		if (memberLoginService.memberLogin(member_id, password, session)) {
			modelAndView.setViewName("redirect:/member/home");
		} else {
			modelAndView.setViewName("redirect:/member/memberAccount/login");
		}
		return modelAndView;
	}

}
