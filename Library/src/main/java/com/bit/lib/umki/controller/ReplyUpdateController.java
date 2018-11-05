package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.service.GetContentService;
import com.bit.lib.umki.service.GetUpdateService;

@Controller
public class ReplyUpdateController {
	
	
	@Autowired 
	GetUpdateService service;

	@RequestMapping(value = "/member/home/view/replyUpdate", method =RequestMethod.POST)
	@ResponseBody
	public int update(@RequestParam("r_idx") int r_idx, @RequestParam("val") String val) {
		int check = service.replyUpdate(r_idx, val);
		
		return check;
	}

}
