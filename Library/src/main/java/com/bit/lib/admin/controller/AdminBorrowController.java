package com.bit.lib.admin.controller;

import com.bit.lib.system.service.ExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/borrow")
public class AdminBorrowController {

	@Autowired
	private ExtensionService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdminLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("count",service.getCount());
		modelAndView.setViewName("/admin/borrow/home");
		return modelAndView;
	}

}
