package com.bit.lib.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.lib.notice.dao.NoticeInterfaceDao;
import com.bit.lib.notice.service.NoticeDeleteService;

@Controller
public class NoticeDeleteController {

	@Autowired
	private NoticeDeleteService service;

	@RequestMapping("/admin/notice/delete")
	public String NoticeDelete(@RequestParam("bId")int bId) {
		
		
		service.deleteLink(bId);
		
		return "redirect:/admin/notice";
	}

}
