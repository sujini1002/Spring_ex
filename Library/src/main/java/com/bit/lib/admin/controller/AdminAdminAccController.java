package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.admin.service.AdminListService;
import com.bit.lib.admin.service.AdminPermissionService;

@Controller
@RequestMapping("/admin/adminAccount")
public class AdminAdminAccController {

	@Autowired
	AdminListService adminListService;

	@Autowired
	AdminPermissionService adminPermissionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/adminAccount/home");
		modelAndView.addObject("admins", adminListService.getAllAdmin());
		modelAndView.addObject("permissions", adminPermissionService.getPermissionNames());

		return modelAndView;
	}

}
