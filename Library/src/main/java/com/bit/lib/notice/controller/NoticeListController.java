package com.bit.lib.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.lib.notice.model.NoticeModel;
import com.bit.lib.notice.service.NoticeListService;

@Controller
public class NoticeListController {
 @Autowired
 private NoticeListService service;
	
	@RequestMapping("/admin/notice")
	public String list(Model model) {
		
		List<NoticeModel> list = service.noticeList();
		model.addAttribute("list", list);
		return"admin/notice/list";
		
	}
}
