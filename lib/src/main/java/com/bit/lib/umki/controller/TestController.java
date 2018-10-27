package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/member/home/listTest/fsdafsdafdsafsadfas")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		ListInfo listInfo = testService.test(); 
		modelAndView.setViewName("list_test");
		modelAndView.addObject("listInfo", listInfo);
		
		
		
		return modelAndView;
	}
	
	
}
