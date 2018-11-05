package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.service.MemberListService;

@Controller
@RequestMapping("/admin/memberAccount")
public class AdminMemberAccController {

	@Autowired
	MemberListService memberListService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/memberAccount/home");
		modelAndView.addObject("members", memberListService.getAllmember());

		return modelAndView;
	}

}
