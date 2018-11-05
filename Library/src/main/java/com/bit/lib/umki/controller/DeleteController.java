package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.lib.umki.service.GetDeleteService;

@Controller
public class DeleteController {
	
	@Autowired
	GetDeleteService service;
	
	@RequestMapping("/member/home/delete")
	public String delete(@RequestParam("idx") int idx) {
		service.delete(idx);
		
		return "redirect:/member/home/list";
	}
}
