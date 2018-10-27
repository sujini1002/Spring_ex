package com.bit.lib.umki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/home/write")
public class WriteController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWriteForm() {
		return "member/list/write";
	}

}
