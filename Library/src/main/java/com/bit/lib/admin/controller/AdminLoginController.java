package com.bit.lib.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.admin.service.AdminLoginService;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {

	@Autowired
	AdminLoginService adminLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		// 로그인 된 상태에서 로그인 페이지 접속시 처리
		if (session.getAttribute("adminLoginInfo") != null) {
			modelAndView.setViewName("/admin/home");
		} else {
			modelAndView.setViewName("/admin/loginForm");
			modelAndView.addObject("adminIds", adminLoginService.getAllAdminId());
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getAdminLogin(@RequestParam("admin_id") String admin_id,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		if (adminLoginService.adminLogin(admin_id, password, session)) {
			modelAndView.setViewName("/admin/home");
		} else {
			modelAndView.setViewName("redirect:/admin/login");
		}
		return modelAndView;
	}

}
