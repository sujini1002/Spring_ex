package com.bit.lib.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.notice.model.NoticeModel;
import com.bit.lib.notice.service.NoticeWriteService;

@Controller
@RequestMapping("/admin/notice/write")
public class NoticeWriteController {
	@Autowired
	private NoticeWriteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String NoticeWrite() {
		
		
		return"admin/notice/write_view";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView NoticeWrite(NoticeModel noticeModel) {
		
		ModelAndView modelAndView = new ModelAndView();
		service.noticeWrite(noticeModel);
		modelAndView.setViewName("redirect:/admin/notice/");
		
		return modelAndView;
		
	}
		

}
