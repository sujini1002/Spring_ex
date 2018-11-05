package com.bit.lib.umki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.umki.model.ReplyInfo;
import com.bit.lib.umki.service.GetWriteContentService;
import com.bit.lib.umki.service.GetWriteService;

@Controller
public class ReplyWriteController {

	@Autowired
	GetWriteService service1;
	@Autowired
	GetWriteContentService service2;

	@RequestMapping(value = "/member/home/view/reply", method =RequestMethod.POST)
	@ResponseBody
	public int write(ReplyInfo replyInfo) {
		int check = service1.replyWrite(replyInfo);
		System.out.println(check);
		return check;
	}
}