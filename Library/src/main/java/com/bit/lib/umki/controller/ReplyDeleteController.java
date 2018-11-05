package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ReplyInfo;
import com.bit.lib.umki.service.GetContentService;
import com.bit.lib.umki.service.GetDeleteService;
import com.bit.lib.umki.service.GetUpdateService;

@Controller
public class ReplyDeleteController {
	
	@Autowired 
	GetDeleteService service;
	
	@RequestMapping(value = "/member/home/view/replyDelete", method =RequestMethod.GET)
	@ResponseBody
	public int getUpdateForm(@RequestParam("r_idx") int r_idx) {
		int check = service.replyDelete(r_idx);
		System.out.println(check);
		return check;
	}
}