package com.bit.lib.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.notice.model.NoticeModel;
import com.bit.lib.notice.service.NoticeViewLInkService;
import com.bit.lib.notice.service.NoticeWriteService;

@Controller
public class NoticeUserViewLinkController {
	
	@Autowired
	private NoticeViewLInkService service;
	
	
	@RequestMapping("/member/notice/viewLink")
	public ModelAndView ViewLink(@RequestParam("bId")int bId) {
		System.out.println("controller"+bId);
		ModelAndView modelAndView = new ModelAndView();
	 
		NoticeModel noticeModel= service.noticeList(bId);
		modelAndView.addObject("viewLink", noticeModel);
		modelAndView.setViewName("member/notice/content_view");
		return modelAndView;
	} 
}
