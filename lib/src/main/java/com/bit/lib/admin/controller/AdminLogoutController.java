package com.bit.lib.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.lib.admin.service.AdminLoginService;

@Controller
@RequestMapping("/admin/logout")
public class AdminLogoutController {

	@Autowired
	AdminLoginService getAdminLoginService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAdminLogout(HttpSession session) {
		session.invalidate();
		return ("redirect:/");
	}
}
