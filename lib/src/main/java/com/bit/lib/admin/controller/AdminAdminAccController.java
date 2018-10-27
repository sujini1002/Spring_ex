package com.bit.lib.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/adminAccount")
public class AdminAdminAccController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/adminAccount/home");
		return modelAndView;
	}

}
