package com.bit.lib.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.lib.admin.service.AdminLoginService;

@Controller
@RequestMapping("/member/memberAccount/logout")
public class MemberLogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAdminLogout(HttpSession session) {
		// session.invalidate();
		session.removeAttribute("memberLoginInfo");
		return ("redirect:/member/home");
	}
}
