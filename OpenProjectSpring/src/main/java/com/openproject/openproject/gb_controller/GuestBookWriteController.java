package com.openproject.openproject.gb_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.openproject.gb_model.Message;
import com.openproject.openproject.gb_service.GuestBookWriteService;
import com.openproject.openproject.model.MemberInfo;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteController {
	
	 @Autowired
	 private GuestBookWriteService writeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String writeFormView() {
		
		return "guest/writeForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView write(Message message) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/guest/list");
		try {
			writeService.insert(message);
		} catch (Exception e) {
			modelAndView.setViewName("guest/writeFail");
		}
		return modelAndView;
	}
	
}
