package com.bit.lib.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.notice.model.NoticeModel;
import com.bit.lib.notice.service.NoticeUpdateService;

@Controller
@RequestMapping("admin/notice/update")
public class NoticeUpdateController { 
	
	@Autowired
	private NoticeUpdateService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView update(@RequestParam("bId")int bId) {
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("admin/notice/updateForm");
		
		modelAndView.addObject("updateBoard", service.updateLink(bId));
		return modelAndView;
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String update2(NoticeModel updateModel) {
		
		service.updateLink2(updateModel);
		
		return "redirect:/admin/notice";
	}
	
}
