package com.bit.lib.umki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.umki.model.ReplyInfo;
import com.bit.lib.umki.service.GetListService;

@Controller
public class ReplyListController {
	
	@Autowired
	GetListService listService;
	
	@RequestMapping("/member/home/view/replyList")
	@ResponseBody
	public List<ReplyInfo> getReplyList(@RequestParam("idx") int idx) {
		List<ReplyInfo> replyInfo = listService.getReplyList(idx);
		
		return replyInfo;
	}
}
