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
	AdminLoginService getAdminLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loginForm");
		modelAndView.addObject("adminIds", getAdminLoginService.getAllAdminId());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getAdminLoginForm(@RequestParam("admin_id") String admin_id,
			@RequestParam("password") String password, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		if (getAdminLoginService.adminLogin(admin_id, password, session)) {
			modelAndView.setViewName("/admin/home");
		} else {
			modelAndView.setViewName("redirect:/admin/login");
		}
		return modelAndView;
	}

}
